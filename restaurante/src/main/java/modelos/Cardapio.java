package modelos;
import java.util.ArrayList;

public class Cardapio{

    
    final ArrayList<Prato> pratos = new ArrayList<>();
    public Cardapio() {
        
        pratos.add(new Prato("Macarao ao molho branco", 75, "Prato Principal"));
        pratos.add(new Prato("Lasanha a bolonhesa", 80, "Prato Principal"));
        pratos.add(new Prato("Batata frita", 15, "Entrada"));
        pratos.add(new Prato("Salada", 20, "Entrada"));
        pratos.add(new Prato("Pudim de leite", 10, "Sobremesa"));
        pratos.add(new Prato("Mousse de maracuja", 12, "Sobremesa"));
    }

    
    

    public void exibirPratos() {
        for (Prato prato : pratos) {
            System.out.println(prato);
        }
    }




}
