package App.tdo;

import java.io.Serializable;

public class CharacterTDO implements Serializable {
    String nombre;
    String altura;
    String masa;
    String colorCabello;
    String colorPiel;
    String colorOjos;
    String anioNacimiento;
    String genero;
    String planetaNatal;
    String especie;

    public CharacterTDO(String nombre, String altura, String masa, String colorCabello, String colorPiel, String colorOjos, String anioNacimiento, String genero, String planetaNatal, String especie) {
        this.nombre = nombre;
        this.altura = altura;
        this.masa = masa;
        this.colorCabello = colorCabello;
        this.colorPiel = colorPiel;
        this.colorOjos = colorOjos;
        this.anioNacimiento = anioNacimiento;
        this.genero = genero;
        this.planetaNatal = planetaNatal;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAltura() {
        return altura;
    }

    public String getMasa() {
        return masa;
    }

    public String getColorCabello() {
        return colorCabello;
    }

    public String getColorPiel() {
        return colorPiel;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public String getAnioNacimiento() {
        return anioNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlanetaNatal() {
        return planetaNatal;
    }

    public String getEspecie() {
        return especie;
    }
}
