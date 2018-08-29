/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.entity;

import br.com.ouvidoria.enums.Sexo;
import br.com.ouvidoria.enums.TipoManifestante;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNacimento;
    private TipoManifestante tipoPessoa;
    @ManyToOne
    private Meio meioResposta;
    
    //Dados Pessoais
    
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String pais;
    
    
    @ManyToOne
    private Cidade municipio;
    
    private String email;
    private String telefone;
    private String celular;

    public Manifestante() {
    }

    public Manifestante(Integer id, String nome, Sexo sexo, Date dataNacimento, TipoManifestante tipoPessoa, 
                        Meio meioResposta, String cep, String endereco, String numero, String complemento, 
                        String bairro, String pais, Cidade municipio, String email, String telefone, 
                        String celular) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNacimento = dataNacimento;
        this.tipoPessoa = tipoPessoa;
        this.meioResposta = meioResposta;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.pais = pais;
        this.municipio = municipio;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(Date dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public TipoManifestante getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoManifestante tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Meio getMeioResposta() {
        return meioResposta;
    }

    public void setMeioResposta(Meio meioResposta) {
        this.meioResposta = meioResposta;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Cidade getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Cidade municipio) {
        this.municipio = municipio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    
    
}
