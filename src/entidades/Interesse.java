package entidades;

import interfaces.InterfaceCli;
import java.io.Serializable;

/**
 * Classe para os registros de interesse.
 * O preço representa o valor máximo a ser pago à uma ação, ou o preço mínimo de venda de uma ação.
 * 
 * @author Henrique
 */

public class Interesse implements Serializable {
    private Acao acao;    
    private double preco; 
    private InterfaceCli cliente;

    /**
     * Método para a construção de um interesse.
     * 
     * @param acao Ação para ser negociada.
     * @param preco Preço a ser negociado.
     * @param cliente Acionista que deseja negociar.
     */
    public Interesse(Acao acao, double preco, InterfaceCli cliente) {
        this.acao = acao;        
        this.preco = preco;
        this.cliente = cliente;
    }   

    /**
     * Método retorna uma ação.
     * 
     * @return Ação de um interesse.
     */
    public Acao getAcao() {
        return acao;
    }

    /**
     * Método para o registro de uma ação.
     * 
     * @param acao Ação de um acionista.
     */
    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    /**
     * Método que retorna o preco de venda ou compra.
     * 
     * @return valor para compra ou venda.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Método para registrar o preco de compra ou venda.
     * 
     * @param preco valor de venda ou compra.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Método para retornar o acionista que deseja negociar.
     * 
     * @return Acionista.
     */
    public InterfaceCli getCliente() {
        return cliente;
    }

    /**
     * Método para registrar o acionista que deseja negociar.
     * 
     * @param cliente Acionista.
     */
    public void setCliente(InterfaceCli cliente) {
        this.cliente = cliente;
    }

    
}