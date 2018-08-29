/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.service;

import br.com.ouvidoria.entity.Estado;
import br.com.ouvidoria.repository.EstadoRespository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alan
 */
@Service
public class EstadoService {
    
    private EstadoRespository repo;
    
    public List<Estado> listarTodos(){
     
        List<Estado> objects = repo.findAll();
        return objects;
    }
    
}
