/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.repositorio;

import com.retos.reto3.interfaz.InterfaceCategoria;
import com.retos.reto3.interfaz.InterfaceClient;
import com.retos.reto3.modelo.Categoria;
import com.retos.reto3.modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class RepositorioClient {
    
    
     @Autowired
    private InterfaceClient crud;
    
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return crud.findById(id);
    }
    
    public Client save(Client client){
        return crud.save(client);
    }
    
    public void delete(Client client){
         crud.delete(client);
    }
    
}
