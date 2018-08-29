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
public enum Sexo {
    
    MASCULINO(1,"Masculino"),
    FEMININO(2,"Feminino"),
    NAOAPLICA(3,"Não se aplica");
    
    private Integer id;
    private String descricao;

    private Sexo(Integer id, String descricao) {
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
    
    public Sexo[] lista(){
        
        return Sexo.values();
    }
    
    public Sexo obterPoPk(Integer id){
        for(Sexo x : values()){
            if(x.getId().equals(id)){
                return x;
            }
        }
        return null;
    }
    
}
