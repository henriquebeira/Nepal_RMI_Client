/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Classe que indica quais métodos um cliente deve possuir.
 * 
 * @author Henrique
 */
public interface InterfaceCli extends Remote {
    
    /**
     * Método que comunica à um cliente que um interesse de venda seu foi negociado.
     * 
     * @param empresa Nome da empresa de uma ação negociada.
     * @param quantidadeAcoes Quantidade negociada.
     * @param precoFinal Valor da negociação.
     * @throws RemoteException 
     */
    public void comunicarVendaEfetuada(String empresa, int quantidadeAcoes, double precoFinal) throws RemoteException;

    /**
     * Método que comunica à um cliente que um interesse de COMPRA seu foi negociado.
     * 
     * @param empresa Nome da empresa de uma ação negociada.
     * @param quantidadeAcoes Quantidade negociada.
     * @param precoFinal Valor da negociação.
     * @throws RemoteException 
     */
    public void comunicarCompraEfetuada(String empresa, int quantidadeAcoes, double precoFinal) throws RemoteException;
   
}
