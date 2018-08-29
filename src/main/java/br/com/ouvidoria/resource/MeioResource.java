/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.resource;

import br.com.ouvidoria.entity.Meio;
import br.com.ouvidoria.service.MeioService;
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
@RequestMapping(value = "/meios")
public class MeioResource {
    
    @Autowired
    private MeioService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Meio>> listarTodos(){
        List<Meio> objcts = service.listarTodos();
        return ResponseEntity.ok(objcts);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obterPoPk(@PathVariable Integer id){

            Meio obj = service.obterPorId(id);
        return ResponseEntity.ok().body(obj);
    }
    
   
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Meio obj, @PathVariable Integer id) {
		obj = service.atualizar(obj);
		return ResponseEntity.noContent().build();
	}
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserir(@RequestBody Meio obj){
    
        service.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
    
        service.deletar(id);
        
        return ResponseEntity.ok().build();
    }
    
    
}
