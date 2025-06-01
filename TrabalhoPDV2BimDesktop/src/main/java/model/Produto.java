
package model;

public class Produto {
    
    private Long id;
    private String descricao;
    private String categoria;
    private double valorUnitario;
    private int quantidade;

    public Produto() {
    }

    public Produto(Long id, String descricao, String categoria, double valorUnitario, int quantidade) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
