package mx.edu.utez.recu.Service.Viajes;


import mx.edu.utez.recu.Viajes.ReposityViajes;
import mx.edu.utez.recu.Viajes.Viajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class ViajesService {
    @Autowired
    private ReposityViajes repository_v;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Viajes>> getAll(){
        return new ResponseEntity<>(this.repository_v.findAll(),HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity<Object>(this.repository_v.findById(id), HttpStatus.OK);
    }

    @Transactional
        public Viajes saveVi(Viajes viajes)
        {
            return repository_v.save(viajes);
        }

        @Transactional
        public Viajes
        updateVi(Viajes viajes,
                Long Id)
        {
            Viajes depDB
                    = repository_v.findById(Id)
                    .get();

            if (Objects.nonNull(viajes.getArrival())
                    && !"".equalsIgnoreCase(
                    viajes.getArrival())) {
                depDB.setArrival(
                        viajes.getArrival());
            }

            if (Objects.nonNull(
                    viajes.getDesparture())
                    && !"".equalsIgnoreCase(
                    viajes.getDesparture())) {
                depDB.setDesparture(
                        viajes.getDesparture());
            }



            return repository_v.save(depDB);
        }

        // Delete operation
        @Transactional
        public void deleteById(Long Id)
        {
            repository_v.deleteById(Id);
        }

    }

