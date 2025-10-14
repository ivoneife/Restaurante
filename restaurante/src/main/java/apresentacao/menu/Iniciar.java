package apresentacao.menu;
import utilitarios.Teclado;
import crud.CrudCliente;
import utilitarios.Video;

public class Iniciar {

    public static String iniciarCadastro(CrudCliente crudCliente) {
        String resposta = Teclado.readString("Deseja se cadastrar no restaurante? (s/n): ").toLowerCase();

        switch (resposta) {
            case "s" -> {
                Video.mensagemOk("Que ótimo! Vamos começar o cadastro.");
                crudCliente.adicionarCliente();
                Video.mensagemInfo("Agora você pode fazer seus pedidos.");
            }
            case "n" -> {
                Video.mensagemInfo("Tudo bem! Você pode fazer pedidos sem cadastro.");
            }
            default -> {
                Video.mensagemAlerta("Resposta inválida. Por favor, responda com 's' ou 'n'.");
            }
        }

        Video.pausa();
        return resposta;
    }
}