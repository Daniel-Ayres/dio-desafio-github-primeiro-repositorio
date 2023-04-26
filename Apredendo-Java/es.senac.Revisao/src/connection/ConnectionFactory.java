
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    //Constanters
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static String  URL = "jdbc:mysql://localhost:3306/dbescola";
    private static String  USER ="root";
    private static String  PASS="123456";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("erro ao tentar conectar Banco de Dados!"+e);
            }
        
    }
    public static void closeConnection(Connection con){
        if (con !=null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Erro ao tentar fechar a conexão"+e);
            }
        }
    }
    public static void closeConnection(Connection con,PreparedStatement stmt){
        if (stmt !=null) {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println("Erro ao tentar fechar Statement"+e);
            }finally{
                closeConnection(con);
            }
        }
    }
    public static void closeConnection(Connection con,PreparedStatement stmt, ResultSet rs){
        if (rs !=null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println("Erro ao tentar fechar ResultSet"+e);
            }finally{
                closeConnection(con,stmt);
            }
        }
    }
}
