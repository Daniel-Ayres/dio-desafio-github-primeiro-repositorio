
package model;

public class Aluno {
    //Atributos
    private int idAluno;
    private String nome;
    private String telefone;
    private String email;
    private int idade;
    
    //Métodos

    public Aluno() {
    }

    public Aluno(int idAluno, String nome, String telefone, String email, int idade) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.idade = idade;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
}
