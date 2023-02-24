package mx.edu.utez.recu.Destinos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recu.Viajes.Viajes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "destinos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Destinos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false, unique = true, length = 150)
    private String name;
    @Column(name = "description", nullable = false, length = 150)
    private String description;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "calification", nullable = false)
    private double calification;
    @Column(name = "disponibilidad", nullable = false)
    private boolean disponibilidad;

    @OneToMany(mappedBy = "destinos")
    @JsonIgnore
    private List<Viajes> viajes;
}
