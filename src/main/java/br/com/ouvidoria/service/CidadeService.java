/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.service;

import br.com.ouvidoria.entity.Cidade;
import br.com.ouvidoria.repository.CidadeRespository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alan
 */

@Service
public class CidadeService {
    
     private CidadeRespository repo;
    
    public List<Cidade> listarTodos(){
     
        List<Cidade> objects = repo.findAll();
        return objects;
    }
    
}
