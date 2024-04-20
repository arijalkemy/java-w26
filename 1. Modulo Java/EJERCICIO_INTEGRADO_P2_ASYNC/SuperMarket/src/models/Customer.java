package models;
public class Customer {
    private String nombre;
    private String apellid;
    private String dni;

    public Customer(String nombre, String apellid, String dni) {
        this.nombre = nombre;
        this.apellid = apellid;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellid() {
        return apellid;
    }

    public void setApellid(String apellid) {
        this.apellid = apellid;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Customer => nombre: " + nombre + ", apellido: " + apellid + ", dni: " + dni;
    }
    
}
