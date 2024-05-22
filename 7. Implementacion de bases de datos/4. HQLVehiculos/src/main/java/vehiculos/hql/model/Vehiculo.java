package vehiculos.hql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehiculos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;
    private String marca;
    private String modelo;
    private Integer anoFabricacion;
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo")
    private Set<Siniestro> siniestros;

}
