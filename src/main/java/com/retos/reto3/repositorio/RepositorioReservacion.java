/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.repositorio;

import com.retos.reto3.interfaz.InterfaceMensaje;
import com.retos.reto3.interfaz.InterfaceReservation;
import com.retos.reto3.modelo.Message;
import com.retos.reto3.modelo.Reservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class RepositorioReservacion {
    
    @Autowired
    private InterfaceReservation crud;
    
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud.findAll();
    }
    
    public Optional<Reservacion> getReservation(int id){
        return crud.findById(id);
    }
    
    public Reservacion save(Reservacion reservacion){
        return crud.save(reservacion);
    }
    
    public void delete(Reservacion reservacion){
         crud.delete(reservacion);
    }
}
