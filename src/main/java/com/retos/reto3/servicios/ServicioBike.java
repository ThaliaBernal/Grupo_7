/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.servicios;

import com.retos.reto3.modelo.Bike;
import com.retos.reto3.repositorio.RepositorioBike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServicioBike {
    
    @Autowired
    private RepositorioBike metodosCrud;
    
     public List<Bike> getAll(){
        return (List<Bike>) metodosCrud.getAll();
    }
    
    public Optional<Bike> getBike(int bikeId){
        return metodosCrud.getBike(bikeId);
    }
    
    public Bike save(Bike bike){
        if(bike.getId() ==null){
            return metodosCrud.save(bike);
        }else{
            Optional<Bike> e = metodosCrud.getBike(bike.getId());
            if(e == null){
                return metodosCrud.save(bike);
            }else{
                return bike;
            }
        }
    }
    
    public Bike update(Bike bike){
        if(bike.getId() !=null){
           Optional<Bike> e = metodosCrud.getBike(bike.getId());
           
           if(e != null){
               if(bike.getName() != null){
                   e.get().setName(bike.getName());
               }
               if(bike.getBrand() != null){
                   e.get().setBrand(bike.getBrand());
               }
               if(bike.getYear() != null){
                   e.get().setYear(bike.getYear());
               }
               if(bike.getDescription() != null){
                   e.get().setDescription(bike.getDescription());
               }
               if(bike.getCategory()!= null){
                   e.get().setCategory(bike.getCategory());
               }
               metodosCrud.save(e.get());
               return e.get();
           }else{
               return bike;
           }
        }else{
            return bike;
        }
    }
    
    public boolean deleteBike(int bikeId){
        Boolean aBoolean = getBike(bikeId).map(bike ->{
        metodosCrud.delete(bike);
        return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
}
