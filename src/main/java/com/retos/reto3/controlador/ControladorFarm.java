/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.controlador;


import com.retos.reto3.modelo.Farm;
import com.retos.reto3.servicios.ServicioFarm;
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
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorFarm {
    
     @Autowired
    private ServicioFarm service;
    
    @GetMapping("/all")
    public List<Farm> getBikes(){
       return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Farm> getBike(@PathVariable("id") int farmId ){
       return service.getFarm(farmId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Farm save(@RequestBody Farm farm ){
       return service.save(farm);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Farm update(@RequestBody Farm farm ){
       return service.update(farm);
    }
    
    @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    public  boolean delete(@PathVariable("id") int farmId ){        
       return service.deleteBike(farmId);
    }
    
}
