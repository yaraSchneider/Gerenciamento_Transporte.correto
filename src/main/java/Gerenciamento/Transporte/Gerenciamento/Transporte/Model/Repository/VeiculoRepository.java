package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Repository;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    boolean existsByPlaca(String placa);

}

