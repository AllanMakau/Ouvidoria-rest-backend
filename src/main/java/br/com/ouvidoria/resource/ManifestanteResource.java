/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.resource;

import br.com.ouvidoria.entity.Manifestante;
import br.com.ouvidoria.entity.Meio;
import br.com.ouvidoria.service.ManifestanteService;
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
@RequestMapping(value = "/manifestantes" )
public class ManifestanteResource {
    
    
    @Autowired
    private ManifestanteService service;
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Manifestante>> listarTodos(){
    
        List<Manifestante> objects = service.listarTodos();
        return ResponseEntity.ok(objects);
    }
    
    @RequestMapping(value = "/{id}", method =  RequestMethod.GET)
    public ResponseEntity<Manifestante> obterPorId(@PathVariable Integer id){
    
       Manifestante obj =  service.obterPorId(id);
        return ResponseEntity.ok(obj);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserir(@RequestBody Manifestante obj){
      
        service.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Manifestante> atualizar(@PathVariable Integer id,@RequestBody Manifestante obj){
        service.atualizar(obj);
        
        return ResponseEntity.noContent().build();
    }
    
    
    
}
