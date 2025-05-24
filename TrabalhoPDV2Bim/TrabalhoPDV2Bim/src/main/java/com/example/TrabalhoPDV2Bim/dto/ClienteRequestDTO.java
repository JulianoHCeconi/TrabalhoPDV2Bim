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
public class ClienteRequestDTO {

    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 60)
    private String nome;

    @NotEmpty
    @NotBlank
    @Size(min = 10, max = 11)
    private String telefone;

    @NotEmpty
    @NotBlank
    @Size(min = 10, max = 60)
    private String email;


}
