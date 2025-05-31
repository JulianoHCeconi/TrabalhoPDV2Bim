
package model;

import java.util.Date;

public class Venda {
    
    private Long id;
    private String observacoes;
    private Date data;
    private Double total;
    private Long cliente_id;

    public Venda() {
    }

    public Venda(Long id, String observacoes, Date data, Double total, Long cliente_id) {
        this.id = id;
        this.observacoes = observacoes;
        this.data = data;
        this.total = total;
        this.cliente_id = cliente_id;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }
    
    
   
    
    
}
