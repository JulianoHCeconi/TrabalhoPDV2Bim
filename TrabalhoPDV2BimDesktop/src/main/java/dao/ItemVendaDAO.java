
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ItemVenda;
import model.Venda;


public class ItemVendaDAO extends GenericDAO<ItemVenda>{
    

    @Override
    protected Object construirObjeto(ResultSet rs) {
        
        ItemVenda itemVenda = new ItemVenda();
         
        try{
            
        itemVenda.setId(rs.getLong("id"));
        itemVenda.setQuantidade(rs.getInt("quantidade"));
        itemVenda.setValorUnitario(rs.getDouble("valor_unitario"));
        itemVenda.setValorTotal(rs.getDouble("valor_total"));
        itemVenda.setVendaId(rs.getLong("venda_id"));
        itemVenda.setProdutoId(rs.getLong("produto_id"));
            
            
        }catch(SQLException ex){
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemVenda;
        
    }


    @Override
    public boolean salvar(ItemVenda itemVenda) {
        
        String sql = "INSERT INTO public.item_venda(\n" +
                     "quantidade, valor_unitario, valor_total, venda_id, produto_id)\n" +
                     "VALUES (?, ?, ?, ?, ?);";
        
        PreparedStatement ps = null;
        
        try{
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, itemVenda.getQuantidade());
            ps.setDouble(2, itemVenda.getValorUnitario());
            ps.setDouble(3, itemVenda.getValorTotal());
            ps.setLong(4, itemVenda.getVendaId());
            ps.setLong(5, itemVenda.getProdutoId());
            ps.executeUpdate();
            ps.close();
            
            return true;
            
        }catch(SQLException ex){
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
