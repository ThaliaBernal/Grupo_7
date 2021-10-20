/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.servicios;

import com.retos.reto3.modelo.Categoria;
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
    
     public List<Categoria> getAll(){
        return (List<Categoria>) metodosCrud.getAll();
    }
    
    public Optional<Categoria> getCategoria(int categoriaId){
        return metodosCrud.getCategoria(categoriaId);
    }
    
    public Categoria save(Categoria categoria){
        if(categoria.getId() ==null){
            return metodosCrud.save(categoria);
        }else{
            Optional<Categoria> e = metodosCrud.getCategoria(categoria.getId());
            if(e == null){
                return metodosCrud.save(categoria);
            }else{
                return categoria;
            }
        }
    }
    
    public Categoria update(Categoria categoria){
        if(categoria.getId() !=null){
           Optional<Categoria> e = metodosCrud.getCategoria(categoria.getId());
           
           if(e != null){
               if(categoria.getName() != null){
                   e.get().setName(categoria.getName());
               }
               if(categoria.getDescription() != null){
                   e.get().setDescription(categoria.getDescription());
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
        Boolean aBoolean = getCategoria(categoriaId).map(categoria ->{
        metodosCrud.delete(categoria);
        return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
}
