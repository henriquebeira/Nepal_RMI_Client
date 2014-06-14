/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.ArrayList;

/**
 * Classe para a criação de uma lista do tipo Acao.
 * 
 * @author Henrique
 */
public class ListaAcoes {
    private ArrayList<Acao> lista = new ArrayList<Acao>();
    
    /**
     * Método para adição de uma Acao na lista.
     * 
     * @param registroAcao Nova Acao
     */
    public void adicionar(Acao registroAcao) {
        lista.add(registroAcao);
    }

    /**
     * Método para remover uma Acao da lista.
     *
     * @param registroAcao Acao para ser apagado da lista.
     */
    public void remover(Acao registroAcao) {
        lista.remove(registroAcao);
    }
    
    /**
     * Método para retornar uma Acao da lista.
     * 
     * @param indice Índice da Acao que deve ser retornado.
     * @return 
     */
    public Acao getAcao(int indice) {
        return lista.get(indice);
    }

    /**
     * Método para retornar o tamanho da lista.
     * 
     * @return Tamanho da lista.
     */
    public int getTamanhoLista() {
        return lista.size();
    }

    /**
     * Método para retornar a lista.
     * 
     * @return Uma lista.
     */
    public ArrayList<Acao> getLista() {
        return new ArrayList(lista);
    }
}
