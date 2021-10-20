/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.repositorio;

import com.retos.reto3.interfaz.InterfaceAdmin;
import com.retos.reto3.modelo.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class RepositorioAdmin {
    
    
    @Autowired
    private InterfaceAdmin crud;
    
    public List<Admin> getAll(){
        return (List<Admin>) crud.findAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return crud.findById(id);
    }
    
    public Admin save(Admin admin){
        return crud.save(admin);
    }
    
    public void delete(Admin admin){
         crud.delete(admin);
    }
    
}
