/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.servicios;

import com.retos.reto3.modelo.Categoria;
import com.retos.reto3.modelo.Client;
import com.retos.reto3.repositorio.RepositorioCategoria;
import com.retos.reto3.repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServicioClient {
    
    @Autowired
    private RepositorioClient metodosCrud;
    
     public List<Client> getAll(){
        return (List<Client>) metodosCrud.getAll();
    }
    
    public Optional<Client> getClient(int clientId){
        return metodosCrud.getClient(clientId);
    }
    
    public Client save(Client client){
        if(client.getIdClient() ==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> e = metodosCrud.getClient(client.getIdClient());
            if(e == null){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    
    public Client update(Client categoria){
        if(categoria.getIdClient() !=null){
           Optional<Client> e = metodosCrud.getClient(categoria.getIdClient());
           
           if(e != null){
               if(categoria.getName() != null){
                   e.get().setName(categoria.getName());
               }
               if(categoria.getEmail() != null){
                   e.get().setEmail(categoria.getEmail());
               }
               if(categoria.getPassword() != null){
                   e.get().setPassword(categoria.getPassword());
               }
               if(categoria.getAge() != null){
                   e.get().setAge(categoria.getAge());
               }
               metodosCrud.save(e.get());
               return e.get();
           }else{
               return categoria;
           }
        }else{
            return categoria;
        }
    }
    
    public boolean deleteClient(int categoriaId){
        Boolean aBoolean = getClient(categoriaId).map(categoria ->{
        metodosCrud.delete(categoria);
        return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
}
