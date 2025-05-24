package com.example.TrabalhoPDV2Bim.domain;


import com.example.TrabalhoPDV2Bim.dto.ItemVendaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_venda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item_Venda {

    public Item_Venda(Long id, ItemVendaDTO itemVendaDTO){
        this.id = id;
        this.quantidade = itemVendaDTO.getQuantidade();
        this.valor_unitario = itemVendaDTO.getValorUnitario();
        this.valor_total = itemVendaDTO.getValorTotal();
    }

    public Item_Venda(ItemVendaDTO itemVendaDTO){
        this.quantidade = itemVendaDTO.getQuantidade();
        this.valor_unitario = itemVendaDTO.getValorUnitario();
        this.valor_total = itemVendaDTO.getValorTotal();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private Double valor_unitario;

    @Column(nullable = false)
    private Double valor_total;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
