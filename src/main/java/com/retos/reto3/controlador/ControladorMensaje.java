/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.controlador;

import com.retos.reto3.modelo.Client;
import com.retos.reto3.modelo.Message;
import com.retos.reto3.servicios.ServicioClient;
import com.retos.reto3.servicios.ServicioMensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorMensaje {
    @Autowired
    private ServicioMensaje service;
    
    @GetMapping("/all")
    public List<Message> getMensaje(){
       return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Message> getClient(@PathVariable("id") int mensajeId ){
       return service.getMensaje(mensajeId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Message save(@RequestBody Message mensaje ){
       return service.save(mensaje);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Message update(@RequestBody Message mensaje ){
       return service.update(mensaje);
    }
    
    @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
    public  boolean delete(@PathVariable("id") int mensajeId ){        
       return service.deleteMensaje(mensajeId);
    }  
}

