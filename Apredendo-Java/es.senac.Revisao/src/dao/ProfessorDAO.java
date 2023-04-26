
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Professor;


public class ProfessorDAO {
      //Objeto para a conexão
    private ConnectionFactory myConnection = new ConnectionFactory();
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Professor prof = new Professor();
    
    public boolean create(Professor prof){
        boolean right = false;
        con = myConnection.getConnection();
        String sql ="insert into professor(nome, area, telefone, email, formacao) values(?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, prof.getNome());
            stmt.setString(2, prof.getArea());
            stmt.setString(3, prof.getTelefone());
            stmt.setString(4, prof.getEmail());
             stmt.setString(5, prof.getFormacao());
            stmt.executeUpdate();
            right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar inserir novo Professor!"+e);
        }finally{
            myConnection.closeConnection(con, stmt);
        }
        return right;
    }
     public List<Professor> read(){
        List professores = new ArrayList();
        con = myConnection.getConnection();
        String sql="select * from professor";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Professor prof = new Professor();
                prof.setIdProfessor(rs.getInt("idProfessor"));
                prof.setNome(rs.getString("nome"));
                prof.setArea(rs.getString("area"));
                prof.setTelefone(rs.getString("telefone"));
                prof.setEmail(rs.getString("email"));
                prof.setFormacao(rs.getString("formacao"));

                //Adicionar objeto "alu" no ArrayList
                professores.add(prof);
                
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar listar Professor!" +e);
        }finally{
            myConnection.closeConnection(con,stmt,rs);
        }
        return professores;
    }
     public boolean update(Professor prof){
         boolean right = false;
        con = myConnection.getConnection();
        String sql="update professor set nome=?, area=?, telefone=?, email=?, formacao=? where idProfessor=? ";
        try {
           
            stmt = con.prepareStatement(sql);
            stmt.setString(1, prof.getNome());
            stmt.setString(2, prof.getArea());
            stmt.setString(3, prof.getTelefone());
            stmt.setString(4, prof.getEmail());
            stmt.setString(5, prof.getFormacao());
            stmt.setInt(6, prof.getIdProfessor());
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
        String sql="delete from professor where idProfessor=?";
        try {
             stmt = con.prepareStatement(sql);
             stmt.setInt(1, id);
             stmt.executeUpdate();
             right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir Aluno!" +e);
        }finally{
            myConnection.closeConnection(con,stmt);
        }
        return true;
    }
}
