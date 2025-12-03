package Gerenciamento.Transporte.Gerenciamento.Transporte.Controller;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.VeiculoPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Veiculo;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Service.VeiculoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculo")
@AllArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> addVeiculo(@RequestBody @Valid VeiculoPostRequestDTO dto) {
        Veiculo veiculo = veiculoService.addVeiculo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> procurarVeiculo() {
        List<Veiculo> veiculos = veiculoService.buscarVeiculo();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> procurarVeiculoPorId(@PathVariable Integer id) {
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(
            @PathVariable Integer id,
            @RequestBody @Valid VeiculoPostRequestDTO dto
    ) {
        Veiculo atualizado = veiculoService.atualizarVeiculo(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Integer id) {
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
