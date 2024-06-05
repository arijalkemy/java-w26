package com.example.starwars.modelo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Personaje {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("height")
    private int altura;
    @JsonProperty("mass")
    private int masa;
    @JsonProperty("hair_color")
    private String color_cabello;
    @JsonProperty("skin_color")
    private String color_piel;
    @JsonProperty("eye_color")
    private String color_ojos;
    @JsonProperty("birth_year")
    private String agno_nacimiento;
    @JsonProperty("gender")
    private String genero;
    @JsonProperty("homeworld")
    private String planeta_natal;
    @JsonProperty("species")
    private String especie;

    public Personaje(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public String getColor_cabello() {
        return color_cabello;
    }

    public void setColor_cabello(String color_cabello) {
        this.color_cabello = color_cabello;
    }

    public String getColor_piel() {
        return color_piel;
    }

    public void setColor_piel(String color_piel) {
        this.color_piel = color_piel;
    }

    public String getColor_ojos() {
        return color_ojos;
    }

    public void setColor_ojos(String color_ojos) {
        this.color_ojos = color_ojos;
    }

    public String getAgno_nacimiento() {
        return agno_nacimiento;
    }

    public void setAgno_nacimiento(String agno_nacimiento) {
        this.agno_nacimiento = agno_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlaneta_natal() {
        return planeta_natal;
    }

    public void setPlaneta_natal(String planeta_natal) {
        this.planeta_natal = planeta_natal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", masa=" + masa +
                ", color_cabello='" + color_cabello + '\'' +
                ", color_piel='" + color_piel + '\'' +
                ", color_ojos='" + color_ojos + '\'' +
                ", agno_nacimiento='" + agno_nacimiento + '\'' +
                ", genero='" + genero + '\'' +
                ", planeta_natal='" + planeta_natal + '\'' +
                ", especie='" + especie + '\'' +
                '}';
    }
}
