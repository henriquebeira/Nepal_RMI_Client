/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nepal_rmi_client;

import entidades.ControleAcoes;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Classe que inicializa um acionista (Client).
 * 
 * @author Henrique
 */
public class Nepal_RMI_Client {

    /**
     * Método para inicialização de um cliente (acionista), onde um controle de ações é criado para ele.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        Registry referenciaServicoNomes = LocateRegistry.getRegistry("localhost", 1099);
        ControleAcoes controleAcoes = new ControleAcoes();
        ClienteImpl cliente = new ClienteImpl(controleAcoes, referenciaServicoNomes);
        
    }
    
}
