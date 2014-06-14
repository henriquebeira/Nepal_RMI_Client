/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import entidades.Interesse;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Classe que indica quais métodos um servidor deve possuir.
 * 
 * @author Henrique
 */
public interface InterfaceServ extends Remote {
    
    /**
     * Método para retornar os interesses de venda registradas no servidor.
     * 
     * @return Lista de interesses de venda.
     * @throws RemoteException 
     */
    public ArrayList<Interesse> consultarInteresseVenda() throws RemoteException;
    
    /**
     * Método para registrar um interesse de COMPRA de ações de uma determinada empresa.
     * 
     * @param interesseCompra Contém a intenção de COMPRA de uma determinada ação.
     * @throws RemoteException 
     */
    public void adicionarInteresseCompra(Interesse interesseCompra) throws RemoteException;
    
     /**
     * Método para registrar um interesse de VENDA de ações de uma determinada empresa.
     * 
     * @param interesseVenda Contém a intenção de VENDA de uma determinada ação.
     * @throws RemoteException 
     */
    public void adicionarInteresseVenda(Interesse interesseVenda) throws RemoteException;
    
}
