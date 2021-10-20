/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.servicios;

import com.retos.reto3.modelo.Farm;
import com.retos.reto3.repositorio.RepositorioFarm;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServicioFarm {
    
    
    @Autowired
    private RepositorioFarm metodosCrud;
    
     public List<Farm> getAll(){
        return (List<Farm>) metodosCrud.getAll();
    }
    
    public Optional<Farm> getFarm(int farmId){
        return metodosCrud.getFarm(farmId);
    }
    
    public Farm save(Farm farm){
        if(farm.getId() ==null){
            return metodosCrud.save(farm);
        }else{
            Optional<Farm> e = metodosCrud.getFarm(farm.getId());
            if(e == null){
                return metodosCrud.save(farm);
            }else{
                return farm;
            }
        }
    }
    
    public Farm update(Farm farm){
        if(farm.getId() !=null){
           Optional<Farm> e = metodosCrud.getFarm(farm.getId());
           
           if(e != null){
               if(farm.getName() != null){
                   e.get().setName(farm.getName());
               }
               if(farm.getAddress()!= null){
                   e.get().setAddress(farm.getAddress());
               }
               if(farm.getExtension()!= null){
                   e.get().setExtension(farm.getExtension());
               }
               if(farm.getDescription() != null){
                   e.get().setDescription(farm.getDescription());
               }
               if(farm.getCategory()!= null){
                   e.get().setCategory(farm.getCategory());
               }
               metodosCrud.save(e.get());
               return e.get();
           }else{
               return farm;
           }
        }else{
            return farm;
        }
    }
    
    public boolean deleteBike(int farmId){
        Boolean aBoolean = getFarm(farmId).map(farm ->{
        metodosCrud.delete(farm);
        return true;
        }).orElse(false);
        return aBoolean;
    }
}
