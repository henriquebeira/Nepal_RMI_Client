/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.ArrayList;

/**
 * Classe para a criação de uma lista do tipo Interesse.
 * 
 * @author Henrique
 */
public class ListaInteresse {
    private ArrayList<Interesse> lista = new ArrayList<Interesse>();
    
    /**
     * Método para adição de um interesse na lista.
     * 
     * @param registroInteresse Novo interesse (venda ou compra).
     */
    public void adicionar(Interesse registroInteresse) {
        lista.add(registroInteresse);
    }

    /**
     * Método para removerr um interesse da lista.
     *
     * @param registroInteresse Interesse para ser apagado da lista.
     */
    public void remover(Interesse registroInteresse) {
        lista.remove(registroInteresse);
    }
    
    /**
     * Método para retornar um interesse da lista.
     * 
     * @param indice Índice do interesse que deve ser retornado.
     * @return 
     */
    public Interesse getInteresse(int indice) {
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
    public ArrayList<Interesse> getLista() {
        return new ArrayList(lista);
    }


}
