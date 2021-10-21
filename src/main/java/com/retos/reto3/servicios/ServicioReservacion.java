/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.servicios;

import com.retos.reto3.modelo.Category;
import com.retos.reto3.modelo.Reservacion;
import com.retos.reto3.repositorio.RepositorioCategoria;
import com.retos.reto3.repositorio.RepositorioReservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServicioReservacion {
    
       @Autowired
    private RepositorioReservacion metodosCrud;
    
     public List<Reservacion> getAll(){
        return (List<Reservacion>) metodosCrud.getAll();
    }
    
    public Optional<Reservacion> getReservacion(int reservacionId){
        return metodosCrud.getReservation(reservacionId);
    }
    
    public Reservacion save(Reservacion reservacion){
        if(reservacion.getIdReservation() ==null){
            return metodosCrud.save(reservacion);
        }else{
            Optional<Reservacion> e = metodosCrud.getReservation(reservacion.getIdReservation());
            if(e == null){
                return metodosCrud.save(reservacion);
            }else{
                return reservacion;
            }
        }
    }
    
    public Reservacion update(Reservacion reservacion){
        if(reservacion.getIdReservation() !=null){
           Optional<Reservacion> e = metodosCrud.getReservation(reservacion.getIdReservation());
           
           if(e != null){
               if(reservacion.getStartDate() != null){
                   e.get().setStartDate(reservacion.getStartDate());
               }
               if(reservacion.getDevolutionDate() != null){
                   e.get().setDevolutionDate(reservacion.getDevolutionDate());
               }
               if(reservacion.getStatus() != null){
                   e.get().setStatus(reservacion.getStatus());
               }
               if(reservacion.getScore() != null){
                   e.get().setScore(reservacion.getScore());
               }
               metodosCrud.save(e.get());
               return e.get();
           }else{
               return reservacion;
           }
        }else{
            return reservacion;
        }
    }
    
    public boolean deleteReservacion(int reservacionId){
        Boolean aBoolean = getReservacion(reservacionId).map(reservacion ->{
        metodosCrud.delete(reservacion);
        return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
}
