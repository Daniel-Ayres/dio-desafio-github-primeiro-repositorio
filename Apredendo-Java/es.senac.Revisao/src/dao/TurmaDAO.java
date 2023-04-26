

package dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Turma;

public class TurmaDAO {
  private ConnectionFactory myConnection = new ConnectionFactory();
private Connection con;
private PreparedStatement stmt;
private ResultSet rs;
private Turma tur = new Turma();
    
public boolean create(Turma turma){
    boolean right = false;
    con = myConnection.getConnection();
    String sql ="insert into turma (sala, turno, idCurso, idProfessor, status, inicio, termino) values(?,?,?,?,?,?,?)";
    try {
        stmt = con.prepareStatement(sql);
        stmt.setString(1, turma.getSala());
        stmt.setString(2, turma.getTurno());
        stmt.setInt(3, turma.getIdCurso());
        stmt.setInt(4, turma.getIdProfessor());
        stmt.setString(5,turma.getStatus());
        stmt.setDate(6, new java.sql.Date(turma.getInicio().getTime()));
        stmt.setDate(7, new java.sql.Date(turma.getTermino().getTime()));
        stmt.executeUpdate();
        right = true;
    } catch (Exception e) {
        System.out.println("Erro ao tentar inserir nova Turma!"+e);
    }finally{
        myConnection.closeConnection(con, stmt);
    }
    return right;
}


public boolean update(Turma turma) {
    boolean right = false;
    con = myConnection.getConnection();
    String sql = "UPDATE turma SET sala=?, turno=?, idCurso=?, idProfessorr=?, status=?, inicio=?, termino=? WHERE idturma=?";
    try {
        stmt = con.prepareStatement(sql);
        stmt.setString(1, turma.getSala());
        stmt.setString(2, turma.getTurno());
        stmt.setInt(3, turma.getIdCurso());
        stmt.setInt(4, turma.getIdProfessor());
        stmt.setString(5, turma.getStatus());
        stmt.setDate(6, new java.sql.Date(turma.getInicio().getTime()));
        stmt.setDate(7, new java.sql.Date(turma.getTermino().getTime()));
        stmt.setInt(8, turma.getIdTurma()); 
        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            right = true;
        }
    } catch (Exception e) {
        System.out.println("Erro ao tentar atualizar Turma! " + e);
    } finally {
        myConnection.closeConnection(con, stmt);
    }
    return right;
}
    public boolean delete(int id){
        con = myConnection.getConnection();
        boolean right = false;
        String sql="delete from turma where idTurma=?";
        try {
             stmt = con.prepareStatement(sql);
             stmt.setInt(1, id);
             stmt.executeUpdate();
             right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir Turma!" +e);
        }finally{
            myConnection.closeConnection(con,stmt);
        }
        return true;
    }
}
