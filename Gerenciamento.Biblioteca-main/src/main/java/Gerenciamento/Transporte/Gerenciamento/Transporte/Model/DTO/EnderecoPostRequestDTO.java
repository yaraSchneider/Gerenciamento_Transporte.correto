package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record EnderecoPostRequestDTO(@NotBlank String rua,
                                     @NotNull @Positive Integer numero,
                                     @NotBlank String cidade,
                                     @NotBlank String estado,
                                     @NotBlank String bairro,
                                     @NotBlank String cep) {


    public Endereco convertEndereco(){
        return Endereco.builder()
                .rua(this.rua)
                .cidade(this.cidade)
                .numero(this.numero)
                .bairro(this.bairro)
                .cep(this.cep)
                .estado(this.estado)
                .build();
    }
}
