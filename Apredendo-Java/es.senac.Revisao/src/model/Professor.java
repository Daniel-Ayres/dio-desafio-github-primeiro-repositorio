
package model;

public class Professor {
    private int idProfessor;
    private String nome;
    private String area;
    private String telefone;
    private String email;
    private String formacao;
    
    //Métodos

    public Professor() {
    }

    public Professor(int idProfessor, String nome, String area, String telefone, String email, String formacao) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.area = area;
        this.telefone = telefone;
        this.email = email;
        this.formacao = formacao;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    
    
}
