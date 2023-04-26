package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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
            stmt.setString(2,turma.getTurno());
            stmt.setInt(3, turma.getIdCurso());
            stmt.setInt(4, turma.getIdProfessor());
            stmt.setString (5, turma.getStatus());
            
            Date dtInicio = (Date) turma.getInicio();
            java.sql.Date inicio = new java.sql.Date(dtInicio.getTime());
            
            Date dttermino = (Date) turma.getTermino();
            java.sql.Date termino = new java.sql.Date(dttermino.getTime());
            
            
            stmt.setDate(6, (Date) turma.getInicio());
            stmt.setDate(7, (Date) turma.getTermino());
            stmt.executeUpdate();
            right = true;
            
        } catch (Exception e) {
            System.out.println("Erro ao tentar inserir novo Professor!"+e);
        }finally{
            myConnection.closeConnection(con, stmt);
        } 
        return right; 
    }
     public List<Turma> read(){
        con = myConnection.getConnection();
        List turma = new ArrayList();
        String sql="select * from turma";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Turma tur = new Turma ();
                
                tur.setIdTurma(rs.getInt("idTurma"));
                tur.setSala(rs.getString("sala"));
                tur.setTurno(rs.getString("turno"));
                tur.setIdCurso(rs.getInt("idCurso"));
                tur.setIdProfessor(rs.getInt("idProfessor"));
                tur.setInicio(rs.getDate("inicio"));
                tur.setTermino(rs.getDate("termino"));
                             
                turma.add(tur);
            }
                    
        } catch (Exception e) {
            System.out.println("Erro ao tentar listar as turmas!" + e);
        }finally {
             myConnection.closeConnection(con, stmt, rs);
        }
        return turma;
   }
     public boolean update(Turma turma){
        boolean right = false;
        con = myConnection.getConnection();
        String sql="update turma set sala=?, turno=?, idCurso=?, idProfessor=?, status=?, inicio=?, termino=? where idturma=? ";
  
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, turma.getSala());
            stmt.setString(2,turma.getTurno());
            stmt.setInt(3, turma.getIdCurso());
            stmt.setInt(4, turma.getIdProfessor());
            stmt.setString (5, turma.getStatus());
            stmt.setDate(6, (Date) turma.getInicio());
            stmt.setDate(7, (Date) turma.getTermino());
            stmt.executeUpdate();
            right = true;
            
        } catch (Exception e) {
             System.out.println("Erro ao tentar atualizar dados da turma!" + e);
        }finally {
             myConnection.closeConnection(con, stmt);
        }
        return right;
     }
     public boolean delete(int id){
        boolean right = false;
        con = myConnection.getConnection();
        String sql="delete from turma where idTurma=?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt (1, id);
            stmt.executeUpdate();
            right = true;
        } catch (Exception e) {
            System.out.println("Erro ao tentar excluir a turma!" +e);
        }finally {
            myConnection.closeConnection(con, stmt);
        }
        return right;
        }   
     
    } 
     
