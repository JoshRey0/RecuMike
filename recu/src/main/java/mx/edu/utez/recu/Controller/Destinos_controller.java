package mx.edu.utez.recu.Controller;

import mx.edu.utez.recu.Destinos.Destinos;
import mx.edu.utez.recu.Service.Destinos.DestinosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-recu/destinos")
@CrossOrigin(origins = {"*"})
public class Destinos_controller {
    @Autowired
    private DestinosService service;


    @GetMapping("/")
    public ResponseEntity<List<Destinos>> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public Destinos saveDestino(
            @Valid @RequestBody Destinos destinos)
    {
        return service.saveDestino(destinos);
    }
    @PutMapping("/{id}")
    public Destinos
    update(@RequestBody Destinos destinos,
                     @PathVariable("id") Long Id)
    {
        return service.updateDestino(
                destinos, Id);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id")
                                       Long Id)
    {
        service.deleteById(
                Id);
        return "Deleted Successfully";
    }


}
