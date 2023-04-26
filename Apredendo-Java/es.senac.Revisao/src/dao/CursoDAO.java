
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

public class CursoDAO {
     //Objeto para a conexão
    private ConnectionFactory myConnection = new ConnectionFactory();
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Curso curso = new Curso();
    
     public boolean create( Curso curso){
        boolean right = false;
        con = myConnection.getConnection();
        String sql ="insert into curso(nome,categoria,carga_horaria,gratuito) values(?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCategoria());
            stmt.setInt(3, curso.getCarga_horaria());
            stmt.setBoolean(4, curso.getGratuito());
            stmt.executeUpdate();
            right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar inserir novo Curso!"+e);
        }finally{
            myConnection.closeConnection(con, stmt);
        }
        return right;
    }
       public List<Curso> read(){
        List professores = new ArrayList();
        con = myConnection.getConnection();
        String sql="select * from aluno";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("idcurso"));
                curso.setNome(rs.getString("nome"));
                curso.setCategoria(rs.getString("categoria"));
                curso.setCarga_horaria(rs.getInt("carga_horaria"));
                curso.setGratuito(rs.getBoolean("gratuito"));
                //Adicionar objeto "alu" no ArrayList
                curso.add(curso);
                
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar listar Curso!" +e);
        }finally{
            myConnection.closeConnection(con,stmt,rs);
        }
        return professores;
    }
       public boolean update(Curso curso){
         boolean right = false;
        con = myConnection.getConnection();
        String sql="update curso set nome=?, categoria=?, carga_horaria=?, gratuito=? where idCurso=? ";
        try {
           
            stmt = con.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCategoria());
            stmt.setInt(3, curso.getCarga_horaria());
            stmt.setBoolean(4, curso.getGratuito());
            stmt.setInt(5,curso.getIdCurso());
            stmt.executeUpdate();
            right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar atualizar dados do Aluno!" +e);
        }finally{
            myConnection.closeConnection(con,stmt);
        }
        return right;
    }
       public boolean delete(int id){
        con = myConnection.getConnection();
        boolean right = false;
        String sql="delete from curso where idCurso=?";
        try {
             stmt = con.prepareStatement(sql);
             stmt.setInt(1, id);
             stmt.executeUpdate();
             right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir Curso!" +e);
        }finally{
            myConnection.closeConnection(con,stmt);
        }
        return true;
    }
}


