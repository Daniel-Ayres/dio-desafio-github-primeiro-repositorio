package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import model.Matricula;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatriculaDAO {
    
    private ConnectionFactory myConnection = new ConnectionFactory();
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Matricula mat = new Matricula();
    
     public boolean create(Matricula matricula){
        boolean right = false;
        con = myConnection.getConnection();
        String sql ="insert into matricula (idAluno, idTurma, valor, dataMatricula) values(?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);        
            stmt.setInt(1, matricula.getIdAluno());
            stmt.setInt(2, matricula.getIdTurma());
            stmt.setDouble(3, matricula.getValor());
            stmt.setDate(4, (java.sql.Date) (Date) matricula.getDataMatricula());
             
            stmt.executeUpdate();
            right = true;
            
        } catch (Exception e) {
            System.out.println("Erro ao tentar inserir novo aluno!"+e);
        }finally{
            myConnection.closeConnection(con, stmt);
        } 
        return right; 
    }
     
      public List<Matricula> read(){
        con = myConnection.getConnection();
        List matricula = new ArrayList();
        String sql="select * from matricula";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Matricula mat = new Matricula ();
                
                mat.setIdMatricula(rs.getInt("idMatricula"));
                mat.setIdAluno(rs.getInt("idAluno"));
                mat.setIdTurma(rs.getInt("Idturno"));
                mat.setValor(rs.getDouble("valor"));
                mat.setDataMatricula(rs.getDate("dataMatricula"));                
                             
                matricula.add(mat);
            }
                    
        } catch (Exception e) {
            System.out.println("Erro ao tentar listar as matriculas!" + e);
        }finally {
             myConnection.closeConnection(con, stmt, rs);
        }
        return matricula;
   }
       public boolean update(Matricula matricula){
        boolean right = false;
        con = myConnection.getConnection();
        String sql="update matricula set idAluno=?, idTurno=?, valor=?, dataMatricula=? where idMatricula=? ";
  
        try {
            stmt = con.prepareStatement(sql);        
            stmt.setInt(1, matricula.getIdAluno());
            stmt.setInt(2, matricula.getIdTurma());
            stmt.setDouble(3, matricula.getValor());
            stmt.setDate(4, (java.sql.Date) (Date) matricula.getDataMatricula());
             
            stmt.executeUpdate();
            right = true;
            
        } catch (Exception e) {
             System.out.println("Erro ao tentar atualizar dados da matricula!" + e);
        }finally {
             myConnection.closeConnection(con, stmt);
        }
        return right;
     }
     public boolean delete(int id){
        boolean right = false;
        con = myConnection.getConnection();
        String sql="delete from matricula where idMatricula=?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt (1, id);
            stmt.executeUpdate();
            right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir a matricula!" +e);
        }finally {
            myConnection.closeConnection(con, stmt);
        }
        return right;
        }         
}

 
