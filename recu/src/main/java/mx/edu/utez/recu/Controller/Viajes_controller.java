package mx.edu.utez.recu.Controller;


import mx.edu.utez.recu.Service.Viajes.ViajesService;
import mx.edu.utez.recu.Viajes.Viajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-recu/viajes")
@CrossOrigin(origins = {"*"})

public class Viajes_controller {
    @Autowired
    private ViajesService service;


    @GetMapping("/")
    public ResponseEntity<List<Viajes>> getAll(){
        return this.service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public  Viajes savePoke(
            @Valid @RequestBody Viajes viajes)
    {
        return service.saveVi(viajes);
    }
    @PutMapping("/{id}")
    public Viajes
    update(@RequestBody Viajes viajes,
           @PathVariable("id") Long Id)
    {
        return service.updateVi(
                viajes, Id);
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
