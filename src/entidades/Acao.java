/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.io.Serializable;

/**
 * Classe para o registro de uma Ação.
 * As propriedades são: nome da empresa desta ação, quantidade de ações desta empresa.
 * 
 * @author Henrique
 */
public class Acao implements Serializable {
    private String empresa;
    private int quantidade;

    /**
     * Método para construir uma ação.
     * 
     * @param empresa Nome da empresa.
     * @param quantidade Quantidade de ações da empresa.
     */
    public Acao(String empresa, int quantidade) {
        this.empresa = empresa;
        this.quantidade = quantidade;
    }

    /**
     * Método retorna o nome da empresa.
     * 
     * @return Nome da empresa.
     */
    
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Método para registrar o nome da empresa.
     * 
     * @param empresa Nome da empresa.
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Método para retornar a quantidade de ações de uma empresa.
     * 
     * @return Quantidade de ações.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Método para registrar a quantidade de ações de uma empresa.
     * 
     * @param quantidade Quantidade de ações.
     */    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
