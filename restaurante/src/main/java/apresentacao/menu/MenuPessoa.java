package apresentacao.menu;
import java.util.ArrayList;

public class MenuPessoa {

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Cadastrar");
        opcoes.add("Listar");
        opcoes.add("Atualizar");
        opcoes.add("Apagar");
        opcoes.add("Voltar");
        Menu menu = new Menu("CRUD Pessoa!", opcoes);
        return menu.exibir();
    }
}
