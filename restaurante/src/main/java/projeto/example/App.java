package projeto.example;
import apresentacao.menu.Menu;
import apresentacao.menu.MenuPessoa;
import apresentacao.menu.MenuPrincipal;
import modelos.Cardapio;
import modelos.Garcom;
import modelos.Pedido;
import utilitarios.Teclado;
import utilitarios.Video;
import java.util.ArrayList;
import crud.CrudCliente;
import apresentacao.menu.Iniciar;
import modelos.Cliente;
import apresentacao.menu.MenuCliente;
import apresentacao.menu.MenuPedido;

public class App {
    public static void main(String[] args) {
        
        int opcao;
        int opçaoCrud;
        String resposta;
        CrudCliente crudCliente = new CrudCliente();
       
        do {
            Video.cabecalho("Restaurante ...");
            System.out.println("Seja bem vindo ao nosso restaurante!");
            Video.separador();

            resposta = Iniciar.iniciarCadastro(crudCliente);
            do{
                opcao = Menu.exibirExemplo();
                switch (opcao) {
                    case 1:
                        MenuCliente.exibir(crudCliente);
                        break;
                    
                    case 2:
                        MenuPedido.exibir(crudCliente);
                    
                        break;
                    
                    default:
                        break;
                }
            }while(opcao != 3);

        } while (opcao != 3);

        
    }
}
