package apresentacao.menu;
import crud.CrudCliente;
import apresentacao.menu.MenuPagamento;
import modelos.Cardapio;
import modelos.Cliente;
import modelos.Garcom;
import modelos.Pedido;
import utilitarios.Teclado;
import utilitarios.Video;

public class MenuPedido {
    public static void exibir( CrudCliente crudCliente) {
        Video.separador();


        crudCliente.listarClientes();
        if(crudCliente.getQuantidadeClientes() == 0) {

            String opcao = Teclado.readString("Deseja cadastrar um cliente? (s/n): ");

             if (Character.toLowerCase(opcao.charAt(0)) == 's') {
                crudCliente.adicionarCliente();
                Video.finalizarTela();
                
             } else {
                Video.finalizarTela();
                return;
             }
        }
        System.out.print("Digite o número do cliente que fará o pedido: "); 
        int indice = Teclado.readInt() - 1;
        Cliente cliente = crudCliente.buscarClientePorIndice(indice);

        if (cliente == null) {
            Video.mensagemErro("Cliente inválido. Voltando ao menu principal.");
            Video.finalizarTela();
            return;
        }

        Garcom garcom = new Garcom("ivonei", 18, "12345678900", 01, 0.10);
        Pedido pedido = new Pedido(cliente, garcom);
        Cardapio cardapio = new Cardapio();
        
        int opcaoPedido;
        do {
            Video.limparTela();
            Video.cabecalho("Menu de Pedidos");
            System.out.println("1 - Ver cardápio");
            System.out.println("2 - Adicionar prato ao pedido");
            System.out.println("3 - Ver resumo do pedido");
            System.out.println("4 - Finalizar pedido");
            Video.separador();

            opcaoPedido = Teclado.readInt("Escolha uma opção: ");
            switch (opcaoPedido) {
                case 1:
                    cardapio.exibirPratos();
                    Video.finalizarTela();
                    break;

                case 2:
                    cardapio.exibirPratos();
                    int pratoEscolhido = Teclado.readInt("Digite o número do prato que deseja adicionar: ") - 1;
                    if (pratoEscolhido < 0 || pratoEscolhido >= cardapio.getQuantidadePratos()) {
                        Video.mensagemErro("Prato inválido.");
                    } else {
                        pedido.adicionarPrato(cardapio.getPrato(pratoEscolhido));
                        Video.mensagemOk("Prato adicionado ao pedido.");
                    }
                    Video.finalizarTela();
                    break;
                case 3:
                    pedido.exibirDetalhesPedido();
                    Video.finalizarTela();
                    break;
                case 4:
                    MenuPagamento.exibir(pedido);
                    Video.finalizarTela();
                    break;
                default:
                    Video.mensagemErro("Opção inválida. Tente novamente.");
            }
        } while (opcaoPedido != 4);
    }        
}
