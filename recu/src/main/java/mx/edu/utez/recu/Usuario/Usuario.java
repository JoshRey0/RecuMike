package mx.edu.utez.recu.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recu.Viajes.Viajes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 150)
    private String name;
    @Column(name = "email",nullable = false,length = 150)
    private String email;
    @Column(name = "date",nullable = false,length = 150)
    private String date;
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Viajes> viajes;
}
