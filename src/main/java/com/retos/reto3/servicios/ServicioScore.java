/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retos.reto3.servicios;

import com.retos.reto3.modelo.Score;
import com.retos.reto3.repositorio.RepositorioScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServicioScore {
    
    @Autowired
    private RepositorioScore metodosCrud;
    
     public List<Score> getAll(){
        return (List<Score>) metodosCrud.getAll();
    }
    
    public Optional<Score> getScore(int scoreId){
        return metodosCrud.getScore(scoreId);
    }
    
    public Score save(Score score){
        if(score.getIdScore() ==null){
            return metodosCrud.save(score);
        }else{
            Optional<Score> e = metodosCrud.getScore(score.getIdScore());
            if(e == null){
                return metodosCrud.save(score);
            }else{
                return score;
            }
        }
    }
    
    public Score update(Score score){
        if(score.getIdScore() !=null){
           Optional<Score> e = metodosCrud.getScore(score.getIdScore());
           
           if(e != null){
               if(score.getScore() != null){
                   e.get().setScore(score.getScore());
               }
               if(score.getMessages() != null){
                   e.get().setMessages(score.getMessages());
               }
               if(score.getReservations()!= null){
                   e.get().setReservations(score.getReservations());
               }
               metodosCrud.save(e.get());
               return e.get();
           }else{
               return score;
           }
        }else{
            return score;
        }
    }
    
    public boolean deleteScore(int scoreId){
        Boolean aBoolean = getScore(scoreId).map(score ->{
        metodosCrud.delete(score);
        return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
