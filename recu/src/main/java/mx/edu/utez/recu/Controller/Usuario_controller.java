package mx.edu.utez.recu.Controller;


import mx.edu.utez.recu.Service.Usuario.UsuarioService;
import mx.edu.utez.recu.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-recu/usuarios")
@CrossOrigin(origins = {"*"})
public class Usuario_controller {
    @Autowired
    private UsuarioService service;


    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public Usuario saveUsu(
            @Valid @RequestBody Usuario usuario)
    {
        return service.saveUsu(usuario);
    }
    @PutMapping("/{id}")
    public Usuario
    update(@RequestBody Usuario usuario,
                     @PathVariable("id") Long Id)
    {
        return service.updateUsu(
                usuario, Id);
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
