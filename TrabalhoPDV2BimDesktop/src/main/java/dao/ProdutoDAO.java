
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ItemVenda;
import model.Produto;

public class ProdutoDAO extends GenericDAO<Produto>{

    @Override
    protected Object construirObjeto(ResultSet rs) {
        
        Produto produto = new Produto();
         
        try{
            
        produto.setId(rs.getLong("id"));
        produto.setQuantidade(rs.getInt("quantidade"));
        produto.setCategoria("categoria");
        produto.setDescricao("descricao");
        produto.setValorUnitario(rs.getDouble("valor_unitario"));
            
            
        }catch(SQLException ex){
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produto;
        
    }

    @Override
    public boolean salvar(Produto produto) {
        
        String sql = "INSERT INTO public.produtos(\n" +
                     "descricao, categoria, valor_unitario, quantidade)\n" +
                     "VALUES (?, ?, ?, ?);";
        
        PreparedStatement ps = null;
        
        try{
            
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produto.getDescricao());
            ps.setString(2, produto.getCategoria());
            ps.setDouble(3, produto.getValorUnitario());
            ps.setInt(4, produto.getQuantidade());
            ps.executeUpdate();
            ps.close();
            
            return true;
            
        }catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    
    
}
