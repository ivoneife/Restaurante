package modelos;

public class Garcom extends Pessoa {
    private int codigo;
    private double taxaServico = 0.10; 

    public Garcom(String nome, int idade, String cpf, int codigo, double taxaServico) {
        super(nome, idade, cpf);
        setCodigo(codigo);
        this.taxaServico = taxaServico;
    }

    public double getTaxaServico() { return taxaServico; }
    
    
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    @Override
    public String toString() {
        return super.toString() + ", Código: " + getCodigo();
    }

}
