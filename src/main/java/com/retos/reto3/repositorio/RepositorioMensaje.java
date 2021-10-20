/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.repositorio;

import com.retos.reto3.interfaz.InterfaceBike;
import com.retos.reto3.interfaz.InterfaceCategoria;
import com.retos.reto3.interfaz.InterfaceMensaje;
import com.retos.reto3.modelo.Bike;
import com.retos.reto3.modelo.Mensaje;
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
    
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud.findAll();
    }
    
    public Optional<Mensaje> getMensaje(int id){
        return crud.findById(id);
    }
    
    public Mensaje save(Mensaje mensaje){
        return crud.save(mensaje);
    }
    
    public void delete(Mensaje mensaje){
         crud.delete(mensaje);
    }
    
    
}
