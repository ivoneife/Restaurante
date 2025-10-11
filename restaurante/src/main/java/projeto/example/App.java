package projeto.example;
import apresentacao.menu.Menu;
import apresentacao.menu.MenuPessoa;
import apresentacao.menu.MenuPrincipal;
import modelos.Cardapio;
import utilitarios.Teclado;
import utilitarios.Video;
import java.util.ArrayList;
import crud.CrudCliente;


public class App {
    public static void main(String[] args) {
        
        int opcao;
        int opçaoCrud;
        String resposta;
       
        do {
            Video.cabecalho("Restaurante ...");
            System.out.println("Seja bem vindo ao nosso restaurante!");
            Video.separador();

            resposta = Teclado.readString("Deseja se cadastrar no restaurante? (s/n): ").toLowerCase();
            if (resposta.equals("s")) {

                Video.mensagemOk("Que ótimo! Vamos começar o cadastro.");
                CrudCliente crudCliente = new CrudCliente();
                crudCliente.adicionarCliente();
                Video.mensagemInfo("Agora você pode fazer seus pedidos.");
                Video.pausa();
            }
            else if (resposta.equals("n")) {
                Video.mensagemInfo("Tudo bem! Você pode fazer pedidos sem cadastro.");
                Video.pausa();
            }
            else {
                Video.mensagemAlerta("Resposta inválida. Por favor, responda com 's' ou 'n'.");
                Video.pausa();
            }

            CrudCliente crudCliente = new CrudCliente();
           
            opcao = Menu.exibirExemplo();
            do{
                switch (opcao) {
                    case 1:
                        opçaoCrud = MenuPessoa.exibir();
                        switch (opçaoCrud) {
                            case 1: 
                                crudCliente.adicionarCliente();
                                break;
                            case 2: 
                                crudCliente.listarClientes();
                                break;
                            case 3:
                                crudCliente.atualizarCliente();
                                break;
                            case 4:
                                crudCliente.deletarCliente();
                                break;
                            case 5:
                                break;
                            default:
                                break;
                        }
                    
                    case 2:
                        Cardapio cardapio = new Cardapio();
                        cardapio.exibirCardapio();
                        int escolha = Teclado.readInt("Digite o número do prato que deseja pedir (0 para sair): ");
                        if (escolha == 0) {
                            Video.mensagemInfo("Voltando ao menu principal...");
                            Video.pausa();
                            break;
                        }
                        cardapio.fazerPedido(escolha);
                        Video.pausa();
                        break;
                    
                    default:
                        break;
                }
            }while(opcao != 3);

            // --- MENU ---
            

            Video.separador();

            System.out.print("Escolha uma opção: ");
            opcao = Teclado.readInt();
            // limpa o ENTER

            Video.limparTela();

            // --- EXECUTAR AÇÃO ---
            switch (opcao) {
                case 1 -> Video.mensagemOk("Operação realizada com sucesso!");
                case 2 -> Video.mensagemErro("Algo deu errado!");
                case 3 -> Video.mensagemAlerta("Cuidado! Campo obrigatório vazio.");
                case 4 -> Video.mensagemInfo("Processando informações...");
                case 5 -> Video.escreverLento("Digitando devagarzinho...", 100);
                case 6 -> Video.barraProgresso(20, 100);
                case 0 -> Video.mensagemInfo("Saindo do sistema...");
                default -> Video.mensagemAlerta("Opção inválida!");
            }

            if (opcao != 0) {
                Video.rodape("Pressione ENTER para voltar ao menu");
                Video.pausa();
            }

        } while (opcao != 0);

        
    }
}
