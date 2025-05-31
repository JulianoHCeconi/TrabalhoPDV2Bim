
package conexaoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDB {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/TrabalhoPDV2BimDesktop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";
    
    public static Connection getConnecion(){
        try{
            
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        }catch(SQLException ex){
            
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }catch(ClassNotFoundException ex){
         
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
           return null; 
    }
    
    
    public static void closeTransaction(Connection conn, PreparedStatement ps){
        
        if(ps != null){
            try{
                
                ps.close();
                
            }catch(SQLException ex){
                
                Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
                
            }
                
        }
        
        closeConnection(conn);
        
    }
    
    private static void closeConnection(Connection conn){
        
        if(conn != null){
            try{
                
                conn.close();
                
            }catch(SQLException ex){
                
                Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
    }
    
}
