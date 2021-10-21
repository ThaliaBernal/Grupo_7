/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.repositorio;

import com.retos.reto3.interfaz.InterfaceCategoria;
import com.retos.reto3.modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class RepositorioCategoria {
    
     @Autowired
    private InterfaceCategoria crud;
    
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    
    public Optional<Category> getCategoria(int id){
        return crud.findById(id);
    }
    
    public Category save(Category categoria){
        return crud.save(categoria);
    }
    
    public void delete(Category categoria){
         crud.delete(categoria);
    }
    
}
