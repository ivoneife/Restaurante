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

        Video.barraProgresso(20,70);
        Video.mensagemOk("\nCliente adicionado com sucesso!");
        Video.finalizarTela();
    }

    public void listarClientes() {
        Video.limparTela();
        Video.separador();
        System.out.println("Lista de Clientes\n");

        if (clientes.isEmpty()) {
            Video.mensagemAlerta("Nenhum cliente cadastrado.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                System.out.println((i + 1) + ". " + cliente);
            }
        }
    }

    public void atualizarCliente() {
        Video.limparTela();
        Video.separador();
        System.out.println("Atualizar Cliente");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            Video.finalizarTela();
            return;
        }

        listarClientes();
        int indice = Teclado.readInt("Digite o número do indice cliente que deseja atualizar: ") - 1;

        if (indice < 0 || indice >= clientes.size()) {
            Video.mensagemErro("Cliente inválido.");
        } else {
            Cliente cliente = clientes.get(indice);

            String nome = Teclado.readString("Digite o novo nome (" + cliente.getNome() + "): ");
            int idade = Teclado.readInt("Digite a nova idade (" + cliente.getIdade() + "): ");
            String cpf = Teclado.readString("Digite o novo CPF (" + cliente.getCpf() + "): ");
            String numeroTelefone = Teclado.readString("Digite o novo número de telefone (" + cliente.getNumeroTelefone() + "): ");

            if (!nome.isEmpty()) cliente.setNome(nome);
            if (idade > 0) cliente.setIdade(idade);
            if (!cpf.isEmpty()) cliente.setCpf(cpf);
            if (!numeroTelefone.isEmpty()) cliente.setNumeroTelefone(numeroTelefone);

            Video.mensagemOk("Cliente atualizado com sucesso!");
        }
        Video.finalizarTela();
    }

    public void deletarCliente() {
        Video.limparTela();
        Video.separador();
        System.out.println("Deletar Cliente");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            Video.finalizarTela();
            return;
        }

        listarClientes();
        int indice = Teclado.readInt("Digite o número do indice cliente que deseja deletar: ") - 1;

        if (indice < 0 || indice >= clientes.size()) {
            Video.mensagemErro("Cliente inválido.");
        } else {
            clientes.remove(indice);
            Video.mensagemOk("Cliente deletado com sucesso!");
        }
        Video.finalizarTela();
    }

    public Cliente buscarClientePorIndice(int indice) {
        if (indice >= 0 && indice < clientes.size()) {
            return clientes.get(indice);
        }
        return null;
    }

    public int getQuantidadeClientes() {
        return clientes.size();
    }
}