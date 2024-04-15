package bootcamp.agenciaTurismo.cliente;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private boolean tieneDescuento;

    public Cliente(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public boolean tieneDescuento() {
        return tieneDescuento;
    }

    public void aplicaADescuento(boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }

}
