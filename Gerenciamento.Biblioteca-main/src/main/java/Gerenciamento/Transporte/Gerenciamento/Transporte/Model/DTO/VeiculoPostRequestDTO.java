package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Motorista;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoPostRequestDTO(
        @NotBlank String marca,
        @NotBlank String modelo,
        @NotBlank String placa,
        @NotNull Motorista motorista
) {

    public Veiculo converterVeiculo(){
        return Veiculo.builder()
                .marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .motorista(this.motorista)
                .build();
    }
}
