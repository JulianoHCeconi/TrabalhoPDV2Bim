package com.example.TrabalhoPDV2Bim.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    @Size(min = 0, max = 100)
    private String descricao;

    @NotEmpty
    @NotBlank
    private Double valor;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 60)
    private String categoria;

}
