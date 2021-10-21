/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.repositorio;

import com.retos.reto3.interfaz.InterfaceMensaje;
import com.retos.reto3.modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class RepositorioMensaje {
    
     @Autowired
    private InterfaceMensaje crud;
    
    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }
    
    public Optional<Message> getMensaje(int id){
        return crud.findById(id);
    }
    
    public Message save(Message mensaje){
        return crud.save(mensaje);
    }
    
    public void delete(Message mensaje){
         crud.delete(mensaje);
    }
    
    
}
