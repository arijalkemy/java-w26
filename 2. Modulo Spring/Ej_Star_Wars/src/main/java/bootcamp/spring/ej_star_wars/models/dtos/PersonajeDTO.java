package bootcamp.spring.ej_star_wars.models.dtos;

import bootcamp.spring.ej_star_wars.models.Personaje;
import lombok.Data;

@Data
public class PersonajeDTO{
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(Personaje pj){
        this.name = pj.getName();
        this.height = pj.getHeight();
        this.mass = pj.getMass();
        this.gender = pj.getGender();
        this.homeworld = pj.getHomeworld();
        this.species = pj.getSpecies();
    }
}
