package mx.edu.utez.recu.Destinos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposityDestinos extends JpaRepository<Destinos,Long> {

        }
