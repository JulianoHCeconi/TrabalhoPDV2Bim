package com.example.TrabalhoPDV2Bim.domain;

import com.example.TrabalhoPDV2Bim.dto.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    public Cliente(ClienteRequestDTO clienteRequestDTO){
        this.nome = clienteRequestDTO.getNome();
        this.telefone = clienteRequestDTO.getTelefone();
        this.email = clienteRequestDTO.getEmail();
    }

    public Cliente(Long id, ClienteRequestDTO clienteRequestDTO){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

}
