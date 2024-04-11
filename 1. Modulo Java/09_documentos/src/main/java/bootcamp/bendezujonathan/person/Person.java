package bootcamp.bendezujonathan.person;

public class Person {
    
    private String nombre;
    private String apellido;


    public Person(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
  

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


}
