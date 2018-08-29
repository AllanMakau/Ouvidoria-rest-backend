/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.repository;

import br.com.ouvidoria.entity.Meio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Alan
 */

@Repository
public interface MeioRepository extends JpaRepository<Meio, Integer>{
    

}
