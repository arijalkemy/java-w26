package org.bootcamp.ejerciciodeportistas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="deportePorPersona")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeportePorPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDeportePersona;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="deporteId",referencedColumnName = "id")
    private Deporte deporte;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="personaId",referencedColumnName = "id")
    private Persona persona;

}
