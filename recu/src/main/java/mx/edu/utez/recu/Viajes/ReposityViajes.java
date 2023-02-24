package mx.edu.utez.recu.Viajes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposityViajes extends JpaRepository<Viajes,Long> {

        }
