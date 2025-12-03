package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

    boolean existsByNumero(Integer numero);
}
