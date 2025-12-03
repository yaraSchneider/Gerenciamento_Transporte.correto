package Gerenciamento.Transporte.Gerenciamento.Transporte.Controller;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.DTO.MotoristaPostRequestDTO;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Model.Entity.Motorista;
import Gerenciamento.Transporte.Gerenciamento.Transporte.Service.MotoristaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/motorista")
@AllArgsConstructor
public class MotoristaController {

    private MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<Motorista> addMotorista(@RequestBody @Valid MotoristaPostRequestDTO motoristaPostRequestDTO){
        try{
            Motorista motorista = motoristaService.addMotorista(motoristaPostRequestDTO);
            return new ResponseEntity<>(motorista, HttpStatus.OK);
        }catch ( Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Motorista>> procurarMotorista(){
        try{
            List<Motorista> motoristas = motoristaService.buscarMotoristas();
            return new ResponseEntity<>(motoristas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> procurarMotoruistaPorId(@PathVariable Integer id){
        try{
            Motorista motorista = motoristaService.buscarMotoristaPorId(id);
            return new ResponseEntity<>(motorista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motorista> atualizarMotorista(@PathVariable Integer id, @RequestBody Motorista motorista){
        try {
            motorista = motoristaService.atualizarMotorista(id, motorista);
            return new ResponseEntity<>(motorista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMotorista(@PathVariable Integer id){
        try {
            motoristaService.deletarMotorista(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}