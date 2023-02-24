package mx.edu.utez.recu.Service.Destinos;


import mx.edu.utez.recu.Destinos.Destinos;
import mx.edu.utez.recu.Destinos.ReposityDestinos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class DestinosService {
    @Autowired
    private ReposityDestinos repository_d;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Destinos>> getAll(){
        return new ResponseEntity<>(this.repository_d.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity(this.repository_d.findById(id),HttpStatus.OK);
    }
    @Transactional
    public Destinos saveDestino(Destinos destinos)
    {
        return repository_d.save(destinos);
    }

    @Transactional
    public Destinos
    updateDestino(Destinos destinos,
                     Long Id)
    {
        Destinos depDB
                = repository_d.findById(Id)
                .get();

        if (Objects.nonNull(destinos.getName())
                && !"".equalsIgnoreCase(
                destinos.getName())) {
            depDB.setName(
                    destinos.getName());
        }



        return repository_d.save(depDB);
    }

    // Delete operation
    @Transactional
    public void deleteById(Long Id)
    {
        repository_d.deleteById(Id);
    }
}
