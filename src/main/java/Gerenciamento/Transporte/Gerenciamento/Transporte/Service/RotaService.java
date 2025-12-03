package Gerenciamento.Transporte.Gerenciamento.Transporte.Service;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.RotaDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Rota;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.RotaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RotaService {

    private final RotaRepository rotaRepository;

    public Rota addRota(Rota rota) {
        return rotaRepository.save(rota);
    }

    public List<RotaDTO> buscarRotasDTO() {
        return rotaRepository.findAll().stream()
                .map(r -> new RotaDTO(
                        r.getId(),
                        r.getOrigem(),
                        r.getDestino(),
                        r.getDistancia(),
                        r.getMotorista()
                ))
                .collect(Collectors.toList());
    }

    public RotaDTO buscarRotaPorIdDTO(Integer id) {
        Optional<Rota> rotaOptional = rotaRepository.findById(id);
        if (rotaOptional.isPresent()) {
            Rota r = rotaOptional.get();
            return new RotaDTO(
                    r.getId(),
                    r.getOrigem(),
                    r.getDestino(),
                    r.getDistancia(),
                    r.getMotorista()
            );
        }
        throw new RuntimeException("Rota não encontrada");
    }

    public Rota atualizarRota(Integer id, Rota rota) {
        rota.setId(id);
        return rotaRepository.save(rota);
    }

    public void deletarRota(Integer id) {
        rotaRepository.deleteById(id);
    }
}
