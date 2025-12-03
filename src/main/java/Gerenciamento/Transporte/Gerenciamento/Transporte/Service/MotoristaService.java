package Gerenciamento.Transporte.Gerenciamento.Transporte.Service;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.MotoristaPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Endereco;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Motorista;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.EnderecoRepository;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.MotoristaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final EnderecoRepository enderecoRepository;

    public Motorista addMotorista(MotoristaPostRequestDTO dto){

        if (motoristaRepository.existsByNome(dto.nome())){
            throw new RuntimeException("Motorista já existe");
        }

        Endereco endereco = dto.endereco().convertEndereco();
        enderecoRepository.save(endereco);

        Motorista motorista = dto.converterMotorista();
        motorista.setEndereco(endereco);

        return motoristaRepository.save(motorista);
    }

    public List<Motorista> buscarMotoristas(){
        return motoristaRepository.findAll();
    }

    public Motorista buscarMotoristaPorId(Integer id){
        return motoristaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
    }

    public Motorista atualizarMotorista(Integer id,Motorista motorista){
        motorista.setId(id);
        return motoristaRepository.save(motorista);
    }

    public void deletarMotorista(Integer id){
        motoristaRepository.deleteById(id);
    }
}
