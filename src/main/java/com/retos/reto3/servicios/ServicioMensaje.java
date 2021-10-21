/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.servicios;

import com.retos.reto3.modelo.Category;
import com.retos.reto3.modelo.Message;
import com.retos.reto3.repositorio.RepositorioCategoria;
import com.retos.reto3.repositorio.RepositorioMensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServicioMensaje {
    
       @Autowired
    private RepositorioMensaje metodosCrud;
    
     public List<Message> getAll(){
        return (List<Message>) metodosCrud.getAll();
    }
    
    public Optional<Message> getMensaje(int mensajeId){
        return metodosCrud.getMensaje(mensajeId);
    }
    
    public Message save(Message mensaje){
        if(mensaje.getIdMessage() ==null){
            return metodosCrud.save(mensaje);
        }else{
            Optional<Message> e = metodosCrud.getMensaje(mensaje.getIdMessage());
            if(e == null){
                return metodosCrud.save(mensaje);
            }else{
                return mensaje;
            }
        }
    }
    
    public Message update(Message mensaje){
        if(mensaje.getIdMessage() !=null){
           Optional<Message> e = metodosCrud.getMensaje(mensaje.getIdMessage());
           
           if(e != null){
               if(mensaje.getMessageText()!= null){
                   e.get().setMessageText(mensaje.getMessageText());
               }
               metodosCrud.save(e.get());
               return e.get();
           }else{
               return mensaje;
           }
        }else{
            return mensaje;
        }
    }
    
    public boolean deleteMensaje(int mensajeId){
        Boolean aBoolean = getMensaje(mensajeId).map(mensaje ->{
        metodosCrud.delete(mensaje);
        return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
