/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.servicios;

import com.retos.reto3.modelo.Categoria;
import com.retos.reto3.modelo.Mensaje;
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
    
     public List<Mensaje> getAll(){
        return (List<Mensaje>) metodosCrud.getAll();
    }
    
    public Optional<Mensaje> getMensaje(int mensajeId){
        return metodosCrud.getMensaje(mensajeId);
    }
    
    public Mensaje save(Mensaje mensaje){
        if(mensaje.getIdMessage() ==null){
            return metodosCrud.save(mensaje);
        }else{
            Optional<Mensaje> e = metodosCrud.getMensaje(mensaje.getIdMessage());
            if(e == null){
                return metodosCrud.save(mensaje);
            }else{
                return mensaje;
            }
        }
    }
    
    public Mensaje update(Mensaje mensaje){
        if(mensaje.getIdMessage() !=null){
           Optional<Mensaje> e = metodosCrud.getMensaje(mensaje.getIdMessage());
           
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
