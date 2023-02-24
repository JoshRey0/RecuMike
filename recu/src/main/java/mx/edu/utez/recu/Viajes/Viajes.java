package mx.edu.utez.recu.Viajes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recu.Destinos.Destinos;
import mx.edu.utez.recu.Usuario.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "viajes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "departure",nullable = false, unique = true, length = 150)
    private String desparture;
    @Column(name = "arrival", nullable = false, length = 150)
    private String arrival;


    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Destinos destinos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
