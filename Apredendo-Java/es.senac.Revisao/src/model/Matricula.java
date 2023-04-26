
package model;

import java.util.Date;


public class Matricula {
    private int idMatricula;
    private int idAluno;
    private int idTurma;
    private double valor;
    private Date dataMatricula;

    public Matricula() {
    }

    public Matricula(int idMatricula, int idAluno, int idTurma, double valor, Date dataMatricula) {
        this.idMatricula = idMatricula;
        this.idAluno = idAluno;
        this.idTurma = idTurma;
        this.valor = valor;
        this.dataMatricula = dataMatricula;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
}
