package Categorias;
import Participante.Participante;

public abstract class Categoria {
    protected int id;
    protected String nombre;
    protected String descripcion;

    public abstract boolean puedeInscribirse(Participante participante);

    public abstract double getMontoAAbonar(Participante participante);

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
