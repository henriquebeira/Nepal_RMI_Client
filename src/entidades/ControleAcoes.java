/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 * Classe que controlará as atividades das ações de um acionista.
 * 
 * @author Henrique
 */
public class ControleAcoes {

    private ListaAcoes listaDeAcoes;
    private ListaInteresse listaDeVendas;
    private ListaInteresse listaDeCompras;
    
    /**
     * Construtora da classe.
     * Criação de Ações iniciais.
     */
    public ControleAcoes() {
        listaDeAcoes = new ListaAcoes();
        listaDeVendas = new ListaInteresse();
        listaDeCompras = new ListaInteresse();
        
        listaDeAcoes.adicionar(new Acao("Sega", 5));
        listaDeAcoes.adicionar(new Acao("Nintendo", 5));
        listaDeAcoes.adicionar(new Acao("Sony", 5));
        listaDeAcoes.adicionar(new Acao("Microsoft", 5));
        
        imprimirListaDeAcoes();
    }
    
    /**
     * Método que atualiza a lista de ações à venda de uma empresa.
     * Atualização da lista de ações pertencentes ao acionista.
     * 
     * @param empresa Nome da empresa da Ação vendida.
     * @param quantidadeAcoes Quantidade de ações vendidas desta empresa.
     * @param precoFinal Preço final obtido com a venda de cada ação.
     */
    public void comunicacaoVendaEfetuada(String empresa, int quantidadeAcoes, double precoFinal) {
        for (int indiceVenda = 0; indiceVenda < listaDeVendas.getTamanhoLista(); indiceVenda++) {
            Interesse venda = (Interesse) listaDeVendas.getInteresse(indiceVenda);
            if (venda.getAcao().getEmpresa().equals(empresa)) {
                int novaQtd = venda.getAcao().getQuantidade() - quantidadeAcoes;
                if (novaQtd == 0) {
                    listaDeVendas.remover(venda);
                } else {
                    venda.getAcao().setQuantidade(novaQtd);
                }
                atualizarListaAcoes(empresa, quantidadeAcoes, "venda");
                break;
            }
        }
        System.out.println("\n Foi realizada uma VENDA de " + quantidadeAcoes + " ações da empresa " + empresa + ". Preço final de cada ação: " + precoFinal);
        imprimirListaDeAcoes();
    }

    /**
     * Método que atualiza a lista de ações à serem compradas de uma empresa.
     * Atualização da lista de ações pertencentes ao acionista.
     * 
     * @param empresa Nome da empresa da Ação comprada.
     * @param quantidadeAcoes Quantidade de ações compradas desta empresa.
     * @param precoFinal Preço final de cada ação comprada.
     */
    public void comunicacaoCompraEfetuada(String empresa, int quantidadeAcoes, double precoFinal) {
        for (int indiceCompra = 0; indiceCompra < listaDeCompras.getTamanhoLista(); indiceCompra++) {
            Interesse compra = (Interesse) listaDeCompras.getInteresse(indiceCompra);
            if (compra.getAcao().getEmpresa().equals(empresa)) {
                int novaQtd = compra.getAcao().getQuantidade() - quantidadeAcoes;
                if (novaQtd == 0) {
                    listaDeCompras.remover(compra);
                } else {
                    compra.getAcao().setQuantidade(novaQtd);
                }
                atualizarListaAcoes(empresa, quantidadeAcoes, "compra");
                break;
            }
        }
        System.out.println("\n Foi realizada uma COMPRA de " + quantidadeAcoes + " ações da empresa " + empresa + ". Preço final de cada ação: " + precoFinal);
        imprimirListaDeAcoes();
    }

    /**
     * Método para adicionar um interesse de venda na lista de ações para vender.
     * 
     * @param venda Objeto que identifica um interesse de venda.
     */
    public void registrarInteresseVenda(Interesse venda) {
        listaDeVendas.adicionar(venda);
    }

    /**
     * Método para adicionar um interesse de COMPRA na lista de ações a serem compradas.
     * 
     * @param compra Objeto que identifica um interesse de compra.
     */
    public void registrarInteresseCompra(Interesse compra) {
        listaDeCompras.adicionar(compra);
    }
    
    /**
     * Método que atualiza a lista de ações que um acionista possui.
     * Caso foi feita uma compra, a quantidade de ações de uma empresa é incrementada.
     * Senão, a quantidade é decrementada.
     * Caso a quantidade fique zero, o registro desta empresa é removido.
     * Senão, é atualizado a quantidade de ações desta empresa.
     * Por fim, se não há registros desta empresa, um registro com as informações necessárias é feito.
     * 
     * @param empresa Nome da empresa em que a sua quantidade será alterada.
     * @param quantidadeAcoes Quantidade de ações a serem adicionadas, ou removidas, de uma empresa.
     * @param tipo O tipo compra indica que é necessário incrementar a quantidade de ações. O tipo venda decrementa.
     */
    private void atualizarListaAcoes(String empresa, int quantidadeAcoes, String tipo) {
        boolean achouAcao = false;
        for (Acao acao : listaDeAcoes.getLista()) {
            if (acao.getEmpresa().equals(empresa)) {
                achouAcao = true;
                int novaQtd = 0;
                
                if (tipo.equals("compra")) {
                    novaQtd = acao.getQuantidade() + quantidadeAcoes;
                } else {
                    novaQtd = acao.getQuantidade() - quantidadeAcoes;
                }
                
                if (novaQtd == 0) {
                    listaDeAcoes.remover(acao);
                } else {
                    acao.setQuantidade(novaQtd);
                }
                break;
            }
        }
        if (!achouAcao) {
            Acao acao = new Acao(empresa, quantidadeAcoes);
            listaDeAcoes.adicionar(acao);
        }
        
    }

    /**
     * Método para imprimir as ações que um acionista possui.
     */
    private void imprimirListaDeAcoes() {
        System.out.println("\n Lista de suas ações: ");
        for (Acao acao : listaDeAcoes.getLista()) {
            System.out.println("Empresa: " + acao.getEmpresa()+ " - Quantidade: " + acao.getQuantidade());
        }
    }
    
}
