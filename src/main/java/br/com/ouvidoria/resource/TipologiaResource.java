/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.resource;

import br.com.ouvidoria.entity.Tipologia;
import br.com.ouvidoria.service.TipologiaService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Alan
 */

@RestController
@RequestMapping(value = "/tipologias")
public class TipologiaResource {
    
    @Autowired
    private TipologiaService service;
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Tipologia>> listarTodos(){
        
        List<Tipologia> objcts =service.listarTodos();
        return ResponseEntity.ok(objcts);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tipologia> obterPorId(@PathVariable Integer id){
        
        Tipologia obj = service.obterPorId(id);
        return ResponseEntity.ok(obj);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserir(@RequestBody Tipologia obj){
    
        service.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar( @RequestBody Tipologia obj,@PathVariable Integer id){
    
        obj = service.atualizar(obj);
        return  ResponseEntity.noContent().build();
    }
    
 
   

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        
        service.deletar(id);
        
        return ResponseEntity.noContent().build();
    }
    
}
