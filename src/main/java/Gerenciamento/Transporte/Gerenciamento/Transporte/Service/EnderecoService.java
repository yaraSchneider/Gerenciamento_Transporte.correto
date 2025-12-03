package Gerenciamento.Transporte.Gerenciamento.Transporte.Service;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.EnderecoPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Endereco;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public Endereco addEndereco(EnderecoPostRequestDTO enderecoPostRequestDTO) {

        if (enderecoRepository.existsByNumero(enderecoPostRequestDTO.numero())) {
            throw new RuntimeException("Número já existente no banco.");
        }

        return enderecoRepository.save(enderecoPostRequestDTO.convertEndereco());
    }

    public List<Endereco> procurarEndereco() {
        return enderecoRepository.findAll();
    }

    public Endereco procurarEnderecoPorId(Integer id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public Endereco atualizarEndereco(Integer id, Endereco endereco) {
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public void deletarEndereco(Integer id) {
        if (!enderecoRepository.existsById(id)) {
            throw new RuntimeException("ID inexistente para deleção");
        }
        enderecoRepository.deleteById(id);
    }
}