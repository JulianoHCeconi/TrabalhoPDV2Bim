package com.example.TrabalhoPDV2Bim.domain;


import com.example.TrabalhoPDV2Bim.dto.ClienteRequestDTO;
import com.example.TrabalhoPDV2Bim.dto.VendaRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {

    public Venda(VendaRequestDTO vendaRequestDTO, Cliente cliente){
        this.observacoes = vendaRequestDTO.getObservacoes();
        this.cliente = cliente;
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
