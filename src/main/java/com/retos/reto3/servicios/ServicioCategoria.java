/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.servicios;

import com.retos.reto3.modelo.Category;
import com.retos.reto3.repositorio.RepositorioCategoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServicioCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;
    
     public List<Category> getAll(){
        return (List<Category>) metodosCrud.getAll();
    }
    
    public Optional<Category> getCategoria(int categoriaId){
        return metodosCrud.getCategoria(categoriaId);
    }
    
    public Category save(Category categoria){
        if(categoria.getId() ==null){
            return metodosCrud.save(categoria);
        }else{
            Optional<Category> e = metodosCrud.getCategoria(categoria.getId());
            if(e == null){
                return metodosCrud.save(categoria);
            }else{
                return categoria;
            }
        }
    }
    
    public Category update(Category categoria){
        if(categoria.getId() !=null){
           Optional<Category> e = metodosCrud.getCategoria(categoria.getId());
           
           if(e != null){
               if(categoria.getName() != null){
                   e.get().setName(categoria.getName());
               }
               if(categoria.getDescription() != null){
                   e.get().setDescription(categoria.getDescription());
               }
               if(categoria.getFarms() != null){
                   e.get().setFarms(categoria.getFarms());
               }
               metodosCrud.save(e.get());
               return e.get();
           }else{
               return categoria;
           }
        }else{
            return categoria;
        }
    }
    
    public boolean deleteCategoria(int categoriaId){
        Boolean aBoolean = getCategoria(categoriaId).map(categoria -> {
        metodosCrud.delete(categoria);
        return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
}
