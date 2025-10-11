package modelos;
import java.util.ArrayList;

public class Pedido implements iterface.Pagavel {
    private Cliente cliente;
    private Garcom garcom;
    private ArrayList<Prato> pratos = new ArrayList<>();

    public Pedido(Cliente cliente, Garcom garcom) {
        setCliente(cliente);
        setGarcom(garcom);
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Garcom getGarcom() { return garcom; }
    public void setGarcom(Garcom garcom) { this.garcom = garcom; }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    @Override
    public double calcularPagamento() {
        double total = 0;
        for (Prato prato : pratos) {
            total += prato.getPreco();
        }
        return total;
    }

    

}
