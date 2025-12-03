package Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne(optional = true)
    private Endereco endereco;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "motorista")
    private List<Veiculo> veiculos = new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "motorista")
    private List<Rota> rotas = new ArrayList<>();
}
