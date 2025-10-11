package modelos;

public class Garcom extends Pessoa {
    private int codigo;

    public Garcom(String nome, int idade, String cpf, int codigo) {
        super(nome, idade, cpf);
        setCodigo(codigo);
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    @Override
    public String toString() {
        return super.toString() + ", Código: " + getCodigo();
    }

}
