package Gerenciamento.Transporte.Gerenciamento.Transporte.Controller;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.EnderecoPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Endereco;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Service.EnderecoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
@AllArgsConstructor
public class EnderecoController {

    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> addEndereco(@RequestBody @Valid EnderecoPostRequestDTO enderecoPostRequestDTO) {
        try {
            Endereco endereco = enderecoService.addEndereco(enderecoPostRequestDTO);
            return new ResponseEntity<>(endereco, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> procurarEndereco() {
        try {
            List<Endereco> enderecos = enderecoService.procurarEndereco();
            return new ResponseEntity<>(enderecos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> procurarEnderecoPorId(@PathVariable Integer id) {
        try {
            Endereco endereco = enderecoService.procurarEnderecoPorId(id);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Integer id,
                                                      @RequestBody Endereco endereco) {
        try {
            endereco = enderecoService.atualizarEndereco(id, endereco);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Integer id) {
        try {
            enderecoService.deletarEndereco(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}