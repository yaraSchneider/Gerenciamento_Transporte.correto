package Gerenciamento.Transporte.Gerenciamento.Transporte.Service;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.VeiculoPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Motorista;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Veiculo;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.MotoristaRepository;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final MotoristaRepository motoristaRepository;


    public Veiculo addVeiculo(VeiculoPostRequestDTO dto) {

        if (veiculoRepository.existsByPlaca(dto.placa())) {
            throw new RuntimeException("Placa já cadastrada!");
        }

        Motorista motorista = dto.motorista();

        if (motorista.getId() != null) {
            motorista = motoristaRepository.findById(motorista.getId())
                    .orElseThrow(() -> new RuntimeException("Motorista não encontrado!"));
        } else {
            motorista = motoristaRepository.save(motorista);
        }

        Veiculo veiculo = dto.converterVeiculo();
        veiculo.setMotorista(motorista);

        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> buscarVeiculo() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarVeiculoPorId(Integer id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));
    }

    public Veiculo atualizarVeiculo(Integer id, VeiculoPostRequestDTO dto) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        veiculo.setMarca(dto.marca());
        veiculo.setModelo(dto.modelo());
        veiculo.setPlaca(dto.placa());

        veiculo.setMotorista(dto.motorista());
        return veiculoRepository.save(veiculo);
    }


    public void deletarVeiculo(Integer id) {
        veiculoRepository.deleteById(id);
    }
}
