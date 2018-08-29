/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ouvidoria.enums;

/**
 *
 * @author Alan
 */
public enum TipoManifestante {
    
    PESSOA_FISICA(1,"Pessoa Física"),
    PESSOA_JURIDICA(2,"Pessoa Jurídica");
    
    private Integer id;
    private String descricao;

    private TipoManifestante(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    private TipoManifestante[] lista(){
    
        return TipoManifestante.values();
    }
    
    private TipoManifestante obterPorPk(Integer id){
        
        for(TipoManifestante x: values()){
            if(x.getId().equals(id)){
                return x;
            }
        }
        return null;
    }
    
}
