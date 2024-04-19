public class SocorristaAuto {
    private String nombre;

    public SocorristaAuto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void socorrer(Vehiculo unAuto) {
        System.out.println("Socorriendo auto...");
    }
}
