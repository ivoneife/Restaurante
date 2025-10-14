package apresentacao.menu;
import crud.CrudCliente;

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
        System.out.print("Digite o número do cliente que fará o pedido: "); 
        int indice = Teclado.readInt() - 1;
        Cliente cliente = crudCliente.buscarClientePorIndice(indice);
        if (cliente == null) {
            Video.mensagemErro("Cliente inválido. Voltando ao menu principal.");
            Video.finalizarTela();
            return;
        }
        Pedido pedido = new Pedido(cliente, new Garcom("ivonei", 18, "12345678900", 101));
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



        } while (opcaoPedido != 4);



       }
                    
}
