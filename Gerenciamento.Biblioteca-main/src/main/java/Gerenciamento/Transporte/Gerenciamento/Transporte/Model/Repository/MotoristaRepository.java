package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Integer> {

    boolean existsByNome(String nome);
}
