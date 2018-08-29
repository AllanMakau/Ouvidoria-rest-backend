/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.service;

import br.com.ouvidoria.entity.Tipologia;
import br.com.ouvidoria.repository.TipologiaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alan
 */

@Service
public class TipologiaService {
    
    @Autowired
    private TipologiaRepository repo;
    
    public List<Tipologia> listarTodos(){
    
       return repo.findAll();
    }
    
    public Tipologia obterPorId(Integer id){
        Optional<Tipologia> obj =repo.findById(id);
        return repo.findById(id).get();
                
    }
    
    public Tipologia inserir(Tipologia obj){
        obj.setId(null);
        return repo.save(obj);
    }
    
    public Tipologia atualizar(Tipologia obj){
        obj = repo.save(obj);
        return obj ;
    }
   
    
    
    public void deletar (Integer id){
        repo.deleteById(id);
    }
    
}
