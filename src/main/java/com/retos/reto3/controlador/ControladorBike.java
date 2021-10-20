/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.controlador;

import com.retos.reto3.modelo.Bike;
import com.retos.reto3.servicios.ServicioBike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/api/Bike")
@CrossOrigin(origins = "*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorBike {
    
    @Autowired
    private ServicioBike service;
    
    @GetMapping("/all")
    public List<Bike> getBikes(){
       return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Bike> getBike(@PathVariable("id") int bikeId ){
       return service.getBike(bikeId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Bike save(@RequestBody Bike bike ){
       return service.save(bike);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Bike update(@RequestBody Bike bike ){
       return service.update(bike);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  boolean delete(@PathVariable("id") int bikeId ){        
       return service.deleteBike(bikeId);
    }
    
    
 
    
    
    
    
}
