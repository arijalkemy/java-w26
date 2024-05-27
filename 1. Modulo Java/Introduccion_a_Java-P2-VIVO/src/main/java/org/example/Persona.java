package org.example;

public class Persona {
   private String nombre;
   private Integer edad;
   private String dni;
   private double pesoKg = 0;

    private Integer alturaCm = 0;

    public Persona(String nombre, Integer edad, String dni, double pesoKg, Integer alturaCm) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.pesoKg = pesoKg;
        this.alturaCm = alturaCm;
    }

    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona() {
    }

    public Integer getIMC(){
        if(this.pesoKg != 0 && this.alturaCm != 0){
           double IMC = pesoKg/(Math.pow(2,(alturaCm/100)));
           if (IMC< 20){ return -1;};
           if (IMC>= 20&& IMC<=25){ return 0;};
           if (IMC> 25){ return 1;};
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", pesoKg=" + pesoKg +
                ", alturaCm=" + alturaCm +
                '}';
    }

    public boolean isMayor(){
        if (this.edad>18){return true;}
        else return false;
    }

}
