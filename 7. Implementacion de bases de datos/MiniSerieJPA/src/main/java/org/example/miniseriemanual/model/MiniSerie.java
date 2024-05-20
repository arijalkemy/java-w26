package org.example.miniseriemanual.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "miniserie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double rating;
    @JsonProperty("amount_of_awards")
    private Integer amount_of_awards;
    /*
    @OneToMany
    @JoinColumn(name = "id_miniserie")
    private List<Chapter> chapter;
*/
}