package StarWars.Ejercicio.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Personaje {
    private String name;
    private String height;
    private String mass;
    @JsonProperty
    private String hair_color;
    @JsonProperty
    private String skin_color;
    @JsonProperty
    private String eye_color;
    @JsonProperty
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    public Personaje() {
    }
    // Constructor con todos los atributos
    public Personaje(String name, String height, String mass, String hairColor, String skinColor, String eyeColor,
                     String birthYear, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hairColor;
        this.skin_color = skinColor;
        this.eye_color = eyeColor;
        this.birth_year = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    @JsonIgnore
    public String getHairColor() {
        return hair_color;
    }

    public void setHairColor(String hairColor) {
        this.hair_color = hairColor;
    }
    @JsonIgnore
    public String getSkinColor() {
        return skin_color;
    }

    public void setSkinColor(String skinColor) {
        this.skin_color = skinColor;
    }
    @JsonIgnore
    public String getEyeColor() {
        return eye_color;
    }

    public void setEyeColor(String eyeColor) {
        this.eye_color = eyeColor;
    }
    @JsonIgnore
    public String getBirthYear() {
        return birth_year;
    }

    public void setBirthYear(String birthYear) {
        this.birth_year = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}

