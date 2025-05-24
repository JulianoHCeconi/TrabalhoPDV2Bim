package com.example.TrabalhoPDV2Bim.domain;


import com.example.TrabalhoPDV2Bim.dto.VendaRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "vendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    public Venda(Long id, VendaRequestDTO vendaRequestDTO){
        this.id = id;
        this.observacoes = observacoes;
        this.data = data;
        this.total = total;
        this.cliente = cliente;
    }

    public Venda(VendaRequestDTO vendaRequestDTO){
        this.observacoes = vendaRequestDTO.getObservacoes();
        this.data = getData();
        this.total = getTotal();
        this.cliente = getCliente();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String observacoes;

    @Column(nullable = false)
    private Timestamp data;

    @Column(nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


}
