package com.example.TrabalhoPDV2Bim.domain;

import com.example.TrabalhoPDV2Bim.dto.ProdutoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    public Produto(ProdutoRequestDTO produtoRequestDTO){
        this.descricao = produtoRequestDTO.getDescricao();
        this.valor = produtoRequestDTO.getValor();
        this.categoria = produtoRequestDTO.getCategoria();
    }

    public Produto(Long id, ProdutoRequestDTO produtoRequestDTO){
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private String categoria;

}
