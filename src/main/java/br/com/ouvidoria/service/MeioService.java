/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.service;

import br.com.ouvidoria.entity.Meio;
import br.com.ouvidoria.exception.ObjectNotFoundException;
import br.com.ouvidoria.repository.MeioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Alan
 */

@Service
public class MeioService {
    
    
    @Autowired
    private MeioRepository repo;
    
    
    public List<Meio> listarTodos(){
        return repo.findAll();
    }
    
    public Meio obterPorId(Integer id){
        
        Optional<Meio> obj = repo.findById(id);
        return obj.get();
    }
    
    public void inserir(Meio obj){
        
    obj.setId(null);
       repo.save(obj);
    }
    public Meio atualizar(Meio obj){
        obj = repo.save(obj);
        return obj;
    }
    
    public Meio atualizar1(Meio obj){
     Meio newObj = obterPorId(obj.getId());
		updateData(newObj, obj);
	return repo.save(newObj);
    }
    
    public void deletar(Integer id){
    
       repo.deleteById(id);
    }
   

    private void updateData(Meio newMeio, Meio obj){
    
        newMeio.setDescricao(obj.getDescricao());
        
    }
}
