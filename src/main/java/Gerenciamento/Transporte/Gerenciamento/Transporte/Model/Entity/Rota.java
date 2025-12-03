package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_rota")
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "origem_id", referencedColumnName = "id")
    @JsonManagedReference("rota-origem")
    private Endereco origem;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "destino_id", referencedColumnName = "id")
    @JsonManagedReference("rota-destino")
    private Endereco destino;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    @Column(nullable = false)
    private Double distancia;

}
