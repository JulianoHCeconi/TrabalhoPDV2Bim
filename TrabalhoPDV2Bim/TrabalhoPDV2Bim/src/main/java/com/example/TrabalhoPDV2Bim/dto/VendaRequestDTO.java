package com.example.TrabalhoPDV2Bim.dto;


import com.example.TrabalhoPDV2Bim.domain.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaRequestDTO {

    private Long clienteId;

    @NotEmpty
    @Size(min = 1, max = 255)
    private String observacoes;

    @NotEmpty
    private List<ItemVendaDTO> itens;
}
