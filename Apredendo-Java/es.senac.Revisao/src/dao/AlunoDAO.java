
 
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;


public class AlunoDAO {
    //Objeto para a conexão
    private ConnectionFactory myConnection = new ConnectionFactory();
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Aluno alu = new Aluno();
    
    public boolean create(Aluno aluno){
        boolean right = false;
        con = myConnection.getConnection();
        String sql ="insert into aluno(nome, telefone, email, idade) values(?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTelefone());
            stmt.setString(3, aluno.getEmail());
            stmt.setInt(4, aluno.getIdade());
            stmt.executeUpdate();
            right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar inserir novo Aluno!"+e);
        }finally{
            myConnection.closeConnection(con, stmt);
        }
        return right;
    }
    public List<Aluno> read(){
        List alunos = new ArrayList();
        con = myConnection.getConnection();
        String sql="select * from aluno";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno alu = new Aluno();
                alu.setIdAluno(rs.getInt("idaluno"));
                alu.setNome(rs.getString("nome"));
                alu.setTelefone(rs.getString("telefone"));
                alu.setEmail(rs.getString("email"));
                alu.setIdade(rs.getInt("idade"));
                //Adicionar objeto "alu" no ArrayList
                alunos.add(alu);
                
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar listar Aluno!" +e);
        }finally{
            myConnection.closeConnection(con,stmt,rs);
        }
        return alunos;
    }
    public boolean update(Aluno aluno){
         boolean right = false;
        con = myConnection.getConnection();
        String sql="update aluno set nome=?, telefone=?, email=?, idade=? where idAluno=? ";
        try {
           
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTelefone());
            stmt.setString(3, aluno.getEmail());
            stmt.setInt(4, aluno.getIdade());
            stmt.setInt(5,aluno.getIdAluno());
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
        String sql="delete from aluno where idAluno=?";
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
