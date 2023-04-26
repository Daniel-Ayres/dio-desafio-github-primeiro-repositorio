package dao;
 
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Professor;

public class ProfessorDAO {
    
    private ConnectionFactory myConnection = new ConnectionFactory();
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Professor pro = new Professor();
    
    public boolean create(Professor professor){
        boolean right = false;
        con = myConnection.getConnection();
        String sql ="insert into professor(nome, area, telefone, email, formacao) values(?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getArea());
            stmt.setString(3, professor.getTelefone());
            stmt.setString(4, professor.getEmail());
            stmt.setString(5, professor.getFormacao());
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
        con = myConnection.getConnection();
        List professor = new ArrayList();
        String sql="select * from professor";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Professor pro = new Professor ();
                
                pro.setIdProfessor(rs.getInt("idProfessor"));
                pro.setNome(rs.getString ("nome"));
                pro.setArea(rs.getString("area"));
                pro.setTelefone((rs.getString ("telefone")));
                pro.setEmail(rs.getString ("email"));
                pro.setFormacao (rs.getString ("formacao"));
                             
                professor.add(pro);
            }
                    
        } catch (Exception e) {
            System.out.println("Erro ao tentar listar os professores!" + e);
        }finally {
             myConnection.closeConnection(con, stmt, rs);
        }
        return professor;
   }
   public boolean update(Professor professor){
        boolean right = false;
        con = myConnection.getConnection();
        String sql="update professor set nome=?, area=?, telefone=?, email=?, formacao=? where idProfessor=? ";
  
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2,professor.getArea()); 
            stmt.setString(3, professor.getTelefone());
            stmt.setString(4, professor.getEmail());
            stmt.setString(5,professor.getFormacao());
            stmt.setInt(6, professor.getIdProfessor());
            stmt.executeUpdate();
            right = true;
            
        } catch (Exception e) {
             System.out.println("Erro ao tentar atualizar dados do aluno!" + e);
        }finally {
             myConnection.closeConnection(con, stmt);
        }
        return right;
    } 
   
   public boolean delete(int id){
        boolean right = false;
        con = myConnection.getConnection();
        String sql="delete from professor where idProfessor=?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt (1, id);
            stmt.executeUpdate();
            right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir professor!" +e);
        }finally {
            myConnection.closeConnection(con, stmt);
        }
        return right;
    }   
   
}

