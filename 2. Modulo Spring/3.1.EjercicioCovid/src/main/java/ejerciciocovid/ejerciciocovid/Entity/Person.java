package ejerciciocovid.ejerciciocovid.Entity;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    int id;
    String nombre;
    String apellido;
    int edad;
    List<Symptom> symptoms;

    public Person(int id, String nombre, String apellido, int edad, List<Symptom> symptoms) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.symptoms = symptoms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptom ... symptoms) {
        this.symptoms = List.of(symptoms);
    }
}
