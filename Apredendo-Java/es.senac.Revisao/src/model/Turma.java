
package model;

import java.util.Date;


public class Turma {
    private int idTurma;
    private String sala;
    private String turno;
    private int idCurso;
    private int idProfessor;
    private String status;
    private Date inicio;
    private Date termino;

    public Turma() {
    }

    public Turma(int idTurma, String sala, String turno, int idCurso, int idProfessor, String status, Date inicio, Date termino) {
        this.idTurma = idTurma;
        this.sala = sala;
        this.turno = turno;
        this.idCurso = idCurso;
        this.idProfessor = idProfessor;
        this.status = status;
        this.inicio = inicio;
        this.termino = termino;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }
    
    
}
