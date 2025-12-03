package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cep;

    @OneToOne(mappedBy = "origem")
    @JsonBackReference("rota-origem")
    private Rota rotaOrigem;

    @OneToOne(mappedBy = "destino")
    @JsonBackReference("rota-destino")
    private Rota rotaDestino;
}
