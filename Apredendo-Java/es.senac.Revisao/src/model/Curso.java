
package model;


public class Curso {
    private int idCurso;
    private String nome;
    private String categoria;
    private int carga_horaria;
    private boolean gratuito;

    public Curso() {
    }

    public Curso(int idCurso, String nome, String categoria, int carga_horaria, boolean gratuito) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.categoria = categoria;
        this.carga_horaria = carga_horaria;
        this.gratuito = gratuito;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public boolean getGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public void setGratuito(String sim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
