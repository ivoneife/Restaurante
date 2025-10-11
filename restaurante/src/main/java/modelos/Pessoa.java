package modelos;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa(String nome, int idade, String cpf) {
        setCpf(cpf);
        setIdade(idade);
        setNome(nome);
    }
    
    public String getNome() { return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public int getIdade() { return idade;}
    public void setIdade(int idade) {this.idade = idade;}

    public String getCpf() { return cpf;}
    public void setCpf(String cpf) { this.cpf = cpf; }

    @Override
    public String toString() {
        return "Nome: " + getNome() + ", Idade: " + getIdade() + ", CPF: " + getCpf();
    }
}   
