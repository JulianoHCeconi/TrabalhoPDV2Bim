
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Venda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class VendaDAO extends GenericDAO<Venda>{
    

    @Override
    protected Object construirObjeto(ResultSet rs) {
        
        Venda venda = null;
        try{
            
            venda = new Venda();
            venda.setObservacoes(rs.getString("observacoes"));
            venda.setData(rs.getDate("data"));
            venda.setTotal(rs.getDouble("total"));
            venda.setCliente_id(rs.getLong("cliente_id"));
            
            
        }catch(SQLException ex){
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return venda;
        
    }

    @Override
    public boolean salvar(Venda venda) {
        
        String sql = "INSERT INTO public.venda(\n" +
                     "observacoes, data, total, cliente_id)\n" +
                     "VALUES (?, ?, ?, ?);";
        
        PreparedStatement ps = null;
        
        try{
            
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, venda.getObservacoes());
            ps.setDate(2, new java.sql.Date(venda.getData().getTime()));
            ps.setDouble(3, venda.getTotal());
            ps.setLong(4, venda.getCliente_id());
            ps.executeUpdate();
            ps.close();
            
            return true;
            
        }catch(SQLException ex){
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    public Long salvarERetornarId(Venda venda) {
        String sql = "INSERT INTO public.venda (observacoes, data, total, cliente_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, venda.getObservacoes());
            ps.setDate(2, new java.sql.Date(venda.getData().getTime()));
            ps.setDouble(3, venda.getTotal());
            ps.setLong(4, venda.getCliente_id());

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public void gerarRelatorio() {
        
        try {
            
            //Responsavel por carregar o relatório
            String relatorioPath = "relatorios/RelatorioVendas.jasper";
            JasperPrint printer = JasperFillManager.fillReport(relatorioPath, null, conn);
            
            //Exibir o relatorio
            JasperViewer view = new JasperViewer(printer, false);
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
