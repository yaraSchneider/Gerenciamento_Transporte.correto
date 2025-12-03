package Gerenciamento.Transporte.Gerenciamento.Transporte.Controller;

import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.RotaDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Rota;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Service.RotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/rota")
@AllArgsConstructor
public class RotaController {

    private final RotaService rotaService;

    @PostMapping
    public ResponseEntity<Rota> addRota(@RequestBody Rota rota){
        try{
            Rota novaRota = rotaService.addRota(rota);
            return new ResponseEntity<>(novaRota, HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RotaDTO>> procurarRota(){
        try {
            List<RotaDTO> rotas = rotaService.buscarRotasDTO();
            return new ResponseEntity<>(rotas, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RotaDTO> procurarRotaPorId(@PathVariable Integer id){
        try{
            RotaDTO rota = rotaService.buscarRotaPorIdDTO(id);
            return new ResponseEntity<>(rota, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> updateRota(@PathVariable Integer id, @RequestBody Rota rota){
        try{
            Rota rotaAtualizada = rotaService.atualizarRota(id, rota);
            return new ResponseEntity<>(rotaAtualizada, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRota(@PathVariable Integer id){
        try {
            rotaService.deletarRota(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
