package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Endereco;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Motorista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RotaDTO {
    private Integer id;
    private Endereco origem;
    private Endereco destino;
    private Double distancia;
    private Motorista motorista;
}
