package mx.edu.utez.recu.Service.Usuario;

import mx.edu.utez.recu.Usuario.Usuario;
import mx.edu.utez.recu.Usuario.UsuarioReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class UsuarioService {
    @Autowired
    private UsuarioReposity repository_u;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Usuario>> getAll(){
        return new ResponseEntity<>(this.repository_u.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity(this.repository_u.findById(id),HttpStatus.OK);
    }
    @Transactional
    public Usuario saveUsu(Usuario usuario)
    {
        return repository_u.save(usuario);
    }

    @Transactional
    public Usuario
    updateUsu(Usuario usuario,
                     Long Id)
    {
        Usuario depDB
                = repository_u.findById(Id)
                .get();

        if (Objects.nonNull(usuario.getName())
                && !"".equalsIgnoreCase(
                usuario.getName())) {
            depDB.setName(
                    usuario.getName());
        }

        if (Objects.nonNull(
                usuario.getEmail())
                && !"".equalsIgnoreCase(
                usuario.getEmail())) {
            depDB.setEmail(
                    usuario.getEmail());
        }


        return repository_u.save(depDB);
    }

    // Delete operation
    @Transactional
    public void deleteById(Long Id)
    {
        repository_u.deleteById(Id);
    }
}
