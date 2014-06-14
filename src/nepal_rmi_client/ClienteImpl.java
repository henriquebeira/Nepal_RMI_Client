/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nepal_rmi_client;

import entidades.Acao;
import entidades.ControleAcoes;
import entidades.Interesse;
import entidades.ListaInteresse;
import interfaces.InterfaceCli;
import interfaces.InterfaceServ;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe principal da implementação Cliente.
 * 
 * @author Henrique
 */
public class ClienteImpl extends UnicastRemoteObject implements InterfaceCli {

    private ControleAcoes controleAcoes;
    private InterfaceServ interfaceServ;
    
    /**
     * Construtora da classe. 
     * Registra a referência remota do Server, recebe um controle de ações, e inicializa o painel de comando.
     * 
     * @param controleAcoes Objeto que controla a lista de ações e de interesses de um acionista.
     * @param reg Registro que possui a referência ao servidor de nomes.
     * @throws RemoteException 
     */
    public ClienteImpl(ControleAcoes controleAcoes, Registry reg) throws RemoteException {
        try {
            interfaceServ = (InterfaceServ) reg.lookup("bolsa_nepal");
            this.controleAcoes = controleAcoes;
            painelDeComando();
            
        } catch (NotBoundException | AccessException ex) {
            Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que prepara a entrada dos comandos: consulta, compra, e venda.
     * A interface com o servidor fornece os seus métodos remotos para serem utilizados.
     * 
     * @throws RemoteException 
     */
    private void painelDeComando() throws RemoteException {
        Scanner entrada = new Scanner(System.in);
        while(true){
            System.out.print("\n Digite 'consulta', compra' ou 'venda': ");
            String comandoDesejado = entrada.nextLine();
            switch(comandoDesejado){
                case "consulta":
                    ArrayList<Interesse> listaInteresseVenda = interfaceServ.consultarInteresseVenda();

                    System.out.println("\n Lista com interesses de venda:");
                    for (int indice = 0; indice < listaInteresseVenda.size(); indice++) {
                        Interesse interesse = (Interesse) listaInteresseVenda.get(indice);
                        System.out.println(interesse.getAcao().getEmpresa() + " - Qtd: " + interesse.getAcao().getQuantidade());
                    }
                    break;
                    
                case "compra":
                    System.out.print("\n Digite o nome da empresa que tenha interesse: ");
                    String nomeEmpresa = entrada.nextLine();
                    System.out.print("\n Digite a quantidade de ações que deseja desta empresa: ");
                    int qtd = Integer.parseInt(entrada.nextLine());
                    System.out.print("\n Digite o valor do preço de compra de cada ação: ");
                    double preco = Double.parseDouble(entrada.nextLine());
                    Acao acao = new Acao(nomeEmpresa, qtd);
                    Interesse registroCompra = new Interesse(acao, preco, this);
                    controleAcoes.registrarInteresseCompra(registroCompra);
                    System.out.println("Interesse de COMPRA de ações da empresa " + nomeEmpresa + " adicionado.");
                    interfaceServ.adicionarInteresseCompra(registroCompra);
                    break;

                case "venda":
                    System.out.print("\n Digite o nome da empresa que queira vender ações: ");
                    nomeEmpresa = entrada.nextLine();
                    System.out.print("\n Digite a quantidade de ações que deseja VENDER desta empresa: ");
                    qtd = Integer.parseInt(entrada.nextLine());
                    System.out.print("\n Digite o valor do preço de VENDA de cada ação: ");
                    preco = Double.parseDouble(entrada.nextLine());
                    acao = new Acao(nomeEmpresa, qtd);
                    Interesse registroVenda = new Interesse(acao, preco, this);
                    controleAcoes.registrarInteresseVenda(registroVenda);
                    System.out.println("Interesse de VENDA de ações da empresa " + nomeEmpresa + " adicionado.");
                    interfaceServ.adicionarInteresseVenda(registroVenda);
                    break;
                
            }
        }
    }
    
    /**
     * Método utilizado pelo servidor para efetuar a comunicação de venda das ações de um acionista.
     * 
     * @param empresa Nome da empresa das ações vendidas no servidor.
     * @param quantidadeAcoes Quantidade de ações vendidas no servidor.
     * @param precoFinal Preço final de cada ação vendida no servidor.
     * @throws RemoteException 
     */
    @Override
    public void comunicarVendaEfetuada(String empresa, int quantidadeAcoes, double precoFinal) throws RemoteException {
        controleAcoes.comunicacaoVendaEfetuada(empresa, quantidadeAcoes, precoFinal);
    }

    /**
     * Método utilizado pelo servidor para efetuar a comunicação de compra de ações por este acionista.
     * 
     * @param empresa Nome da empresa das ações compradas no servidor.
     * @param quantidadeAcoes Quantidade de ações compradas no servidor.
     * @param precoFinal Preço final de cada ação comprada no servidor.
     * @throws RemoteException 
     */
    @Override
    public void comunicarCompraEfetuada(String empresa, int quantidadeAcoes, double precoFinal) throws RemoteException {
        controleAcoes.comunicacaoCompraEfetuada(empresa, quantidadeAcoes, precoFinal);
    }
}
