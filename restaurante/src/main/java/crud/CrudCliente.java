package crud;
import java.util.ArrayList;
import utilitarios.Teclado;
import utilitarios.Video;
import modelos.Cliente;

public class CrudCliente {

    private ArrayList<Cliente> clientes;

    public CrudCliente() {
        clientes = new ArrayList<>();
    }

    // CREATE
    public void adicionarCliente() {
        Video.limparTela();
        Video.separador();
        System.out.println("Cadastro de Cliente");

        String nome = Teclado.readString("Digite seu nome: ");
        int idade = Teclado.readInt("Digite sua idade: ");
        String cpf = Teclado.readString("Digite seu CPF: ");
        String numeroTelefone = Teclado.readString("Digite seu número de telefone: ");

        Cliente novoCliente = new Cliente(nome, idade, cpf, numeroTelefone);
        clientes.add(novoCliente);

        Video.mensagemOk("Cliente adicionado com sucesso!");
        Video.rodape("Pressione ENTER para continuar");
        Video.pausa();
        Video.limparTela();
    }

}
