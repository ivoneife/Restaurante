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
       

        do {
            Video.cabecalho("Restaurante ...");

            System.out.println("Seja bem vindo ao nosso restaurante!");
            Video.separador();

            CrudCliente crudCliente = new CrudCliente();
            crudCliente.adicionarCliente();
            
            

            // --- MENU ---
            System.out.println("1 - Mostrar mensagem OK");
            System.out.println("2 - Mostrar mensagem ERRO");
            System.out.println("3 - Mostrar mensagem ALERTA");
            System.out.println("4 - Mostrar mensagem INFO");
            System.out.println("5 - Efeito de digitação");
            System.out.println("6 - Barra de progresso");
            System.out.println("0 - Sair");

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
