package org.example.miniseriemanual.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Integer length;
    private Integer season;
    /*
    @ManyToOne
    @JoinColumn(name = "id_miniserie")
    private MiniSerie miniSerie;
     */
}
