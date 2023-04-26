/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;


public class Matricula {
    private int idMatricula;
    private int idAluno;
    private int idCurso;
    private double valor;
    private Date dataMatricula;

    public Matricula() {
    }

    public Matricula(int idMatricula, int idAluno, int idCurso, double valor, Date dataMatricula) {
        this.idMatricula = idMatricula;
        this.idAluno = idAluno;
        this.idCurso = idCurso;
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

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
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
