public class SocorristaMoto {
    private String nombre;

    public SocorristaMoto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void socorrer(Vehiculo unaMoto) {
        System.out.println("Socorriendo moto...");
    }
}

