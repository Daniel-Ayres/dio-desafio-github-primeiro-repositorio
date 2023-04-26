
package dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Matricula;

public class MatriculaDAO {

private ConnectionFactory myConnection = new ConnectionFactory();
private Connection con;
private PreparedStatement stmt;
private ResultSet rs;
private Matricula mat = new Matricula();
 
public boolean create(Matricula mat){
    boolean right = false;
    con = myConnection.getConnection();
    String sql ="insert into matricula (IdAluno, IdCurso, valor, dataMatricula) values(?,?,?,?)";
    try {
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, mat.getIdAluno());
        stmt.setInt(2, mat.getIdCurso());
        stmt.setDouble(3, mat.getValor());
        stmt.setDate(4, new java.sql.Date(mat.getDataMatricula().getTime()));;
        stmt.executeUpdate();
        right = true;
    } catch (Exception e) {
        System.out.println("Erro ao tentar inserir nova Matricula!"+e);
    }finally{
        myConnection.closeConnection(con, stmt);
    }
    return right;
}
public boolean update(Matricula mat){
    boolean right = false;
    con = myConnection.getConnection();
    String sql ="update matricula set IdAluno=?, IdCurso=?, valor=?, dataMatricula=? where IdMatricula=?";
    try {
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, mat.getIdAluno());
        stmt.setInt(2, mat.getIdCurso());
        stmt.setDouble(3, mat.getValor());
        stmt.setDate(4, new java.sql.Date(mat.getDataMatricula().getTime()));
        stmt.setInt(5, mat.getIdMatricula());
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            right = true;
        }
    } catch (Exception e) {
        System.out.println("Erro ao tentar atualizar Matricula! "+e);
    } finally {
        myConnection.closeConnection(con, stmt);
    }
    return right;
}
     public boolean delete(int id){
        con = myConnection.getConnection();
        boolean right = false;
        String sql="delete from matricula where idMatricula=?";
        try {
             stmt = con.prepareStatement(sql);
             stmt.setInt(1, id);
             stmt.executeUpdate();
             right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir Matricula!" +e);
        }finally{
            myConnection.closeConnection(con,stmt);
        }
        return true;
    }
}
