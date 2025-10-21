package projeto.example;
import apresentacao.menu.Menu;
import utilitarios.Video;
import crud.CrudCliente;
import apresentacao.menu.Iniciar;
import apresentacao.menu.MenuCliente;
import apresentacao.menu.MenuPedido;

public class App {
    public static void main(String[] args) {
        
        int opcao;
        CrudCliente crudCliente = new CrudCliente();
       
        do {
            Video.cabecalho("Restaurante ...");
            System.out.println("Seja muito bem-vindo ao Restaurante.. nome!\n" + //
                                "Aqui, cada prato é preparado com carinho para tornar sua experiência inesquecível.\n" + 
                                "\nBom apetite!");
            Video.separador();
            Video.pausa();

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

        Video.mensagemOk("Obrigado por usar nosso sistema!");
        Video.finalizarTela();
    }
}