/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.service;

import br.com.ouvidoria.entity.Manifestante;
import br.com.ouvidoria.repository.ManifestanteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alan
 */

@Service
public class ManifestanteService {
    
    
    @Autowired
    private ManifestanteRepository repo;
    
    public List<Manifestante> listarTodos(){
        
        return repo.findAll();
    }
    
    public Manifestante obterPorId(Integer id){
    
        Optional<Manifestante> obj = repo.findById(id);
        return obj.get();    
    }
    
    
    public Manifestante inserir(Manifestante obj){
        
        obj.setId(null);
        obj = repo.save(obj);    
        return obj;
    }
    
    public Manifestante atualizar(Manifestante obj){
        
        obj = repo.save(obj);
        return obj;
    }
    
    public void deletar(Integer id){
        repo.deleteById(id);
    }
}
