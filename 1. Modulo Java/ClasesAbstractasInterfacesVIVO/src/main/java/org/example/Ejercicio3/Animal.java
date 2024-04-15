package org.example.Ejercicio3;

public abstract class Animal {
    private String nombre;

    private String genero;
    private String tipoAnimal;

    public Animal(String nombre, String genero, String tipoAnimal) {
        this.nombre = nombre;
        this.genero = genero;
        this.tipoAnimal = tipoAnimal;
    }

    public String getNombre() {
        return nombre;
    }


    public String getGenero() {
        return genero;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", tipoAnimal='" + tipoAnimal + '\'' +
                '}';
    }

    public abstract void emitirSonido();

    public static void comerAnimal(Animal animal){
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }else if(animal instanceof Herviboro){
            ((Herviboro) animal).comerHierba();
        }
    }

}


