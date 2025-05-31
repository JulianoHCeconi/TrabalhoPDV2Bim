
package dao;

import conexaoDB.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GenericDAO<objeto> {
    
    protected Connection conn;
    
    public GenericDAO(){
        
        conn = ConexaoDB.getConnecion();
        
    }
    
    protected abstract Object construirObjeto(ResultSet rs);
    
    public abstract boolean salvar(objeto obj);
    
    public ArrayList<objeto> retornarLista(String sql){
        
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Object> lista = new ArrayList();
        
        try{
            
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(construirObjeto(rs));
            }
            
            ps.close();
            
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (ArrayList<objeto>) lista;
        
    }
    
}
