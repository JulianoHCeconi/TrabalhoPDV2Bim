package dto;

public class ItemVendaDTO {

    private Long produtoId;
    private Long vendaId;
    private Integer quantidade;
    private Double valorUnitario;
    private Double valorTotal;


    public ItemVendaDTO() {}

    public ItemVendaDTO(Long produtoId, Long vendaId, Integer quantidade, Double valorUnitario, Double valorTotal) {
        this.produtoId = produtoId;
        this.vendaId = vendaId;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }


    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Long getVendaId() {
        return vendaId;
    }

    public void setVendaId(Long vendaId) {
        this.vendaId = vendaId;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}