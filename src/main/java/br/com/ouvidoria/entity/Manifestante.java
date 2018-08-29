/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.entity;

import br.com.ouvidoria.enums.Sexo;
import br.com.ouvidoria.enums.TipoManifestante;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Alan
 */

@Entity
public class Manifestante implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Sexo sexo;
    private Date dataNacimento;
    private TipoManifestante tipoPessoa;
    private String meioResposta;
    
    //Dados Pessoais
    
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String pais;
    private String uf;
    private String municipio;
    
    private String email;
    private String telefone;
    private String celular;
}
