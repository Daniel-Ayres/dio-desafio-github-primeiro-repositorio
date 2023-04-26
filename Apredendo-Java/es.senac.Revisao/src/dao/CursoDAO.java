
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

public class CursoDAO {
   
  private ConnectionFactory myConnection = new ConnectionFactory();
  private Connection con;
  private PreparedStatement stmt;
  private ResultSet rs;
  private Curso cs = new Curso ();
  
  
  public boolean create (Curso curso) {
      boolean right = false;
      con = myConnection.getConnection();
      String sql = "insert into curso(nome, categoria, carga_horaria, gratuito) values (?,?,?,?)";
      try {
          stmt = con.prepareStatement(sql);
          stmt.setString(1,curso.getNome());
          stmt.setString(2,curso.getCategoria());
          stmt.setInt(3, curso.getCarga_horaria());
          stmt.setBoolean(4, curso.getGratuito());
          stmt.executeUpdate();
          right = true;
                  
      } catch (Exception e) {
          System.out.println("Erro ao tentar inserir novo Curso!" + e);
      }finally{
          myConnection.closeConnection(con, stmt);
      }
      return right;
  } 
  
  public List<Curso> read(){
      con = myConnection.getConnection();
      List curso = new ArrayList();
      String sql = "select * from curso";
      try {
          stmt = con.prepareStatement(sql);
          rs = stmt.executeQuery();
          while (rs.next()) {
              Curso cs = new Curso ();
              cs.setIdCurso(rs.getInt("idCurso"));
              cs.setNome(rs.getString("nome"));
              cs.setCategoria(rs.getString("categoria"));
              cs.setCarga_horaria(rs.getInt ("carga_horaria"));
              cs.setGratuito(rs.getBoolean("gratuito"));
              
              curso.add(cs);
          }
      } catch (Exception e) {
          System.out.println("Erro ao tentar listar os Cursos!" + e);
      }finally {
          myConnection.closeConnection(con, stmt, rs);
      }
      return curso;
  }
   public boolean update (Curso curso) {
       boolean right = false;
        con = myConnection.getConnection();
       String sql="update curso set nome=?, categoria=?, carga_horaria=?, gratuito=? where idCurso=? ";
       
       try {
           stmt = con.prepareStatement(sql);
           stmt.setString(1,curso.getNome());
           stmt.setString(2,curso.getCategoria());
           stmt.setInt(3, curso.getCarga_horaria());
           stmt.setBoolean(4, curso.getGratuito());
           stmt.setInt(5, curso.getIdCurso());
           stmt.executeUpdate();
          right = true;
           
       } catch (Exception e) {
           System.out.println("Erro ao tentar atualizar dados do curso!" + e);
       }finally {
             myConnection.closeConnection(con, stmt);
        }
       return right;
    }
   public boolean delete(int id){
        boolean right = false;
        con = myConnection.getConnection();
        String sql="delete from curso where idCurso=?";
        try {
         stmt = con.prepareStatement(sql);
         stmt.setInt (1,id);
         stmt.executeUpdate();
         right = true;
       } catch (Exception e) {
            System.out.println("Erro ao tentar excluir Curso!" +e);
       }finally {
            myConnection.closeConnection(con, stmt);
        }
        return right;
   }
}
