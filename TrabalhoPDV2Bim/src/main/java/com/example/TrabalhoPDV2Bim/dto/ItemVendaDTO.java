package com.example.TrabalhoPDV2Bim.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVendaDTO {

    private Long produtoId;

    private Long vendaId;

    @NotEmpty
    @NotBlank
    @Size(min = 1)
    private Integer quantidade;

    @NotEmpty
    @NotBlank
    private Double valorUnitario;

    @NotEmpty
    @NotBlank
    private Double valorTotal;

}
