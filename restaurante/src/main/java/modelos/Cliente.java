package modelos;

public class Cliente extends Pessoa {
    private String numeroTelefone;

    public Cliente(String nome, int idade, String cpf, String numeroTelefone) {
        super(nome, idade, cpf);
        setNumeroTelefone(numeroTelefone);
    }

    public String getNumeroTelefone() { return numeroTelefone; }
    public void setNumeroTelefone(String numeroTelefone) { this.numeroTelefone = numeroTelefone; }

    @Override
    public String toString() {
        return super.toString() + ", numero telefone: " + getNumeroTelefone();
    }

    


}
