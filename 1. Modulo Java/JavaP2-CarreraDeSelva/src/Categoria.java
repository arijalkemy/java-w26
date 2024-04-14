public class Categoria {
    private String nombre;
    private String descripcion;
    private double montoMenores;
    private double montoMayores;

    public Categoria(String nombre, String descripcion, double montoMenores, double montoMayores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoMenores = montoMenores;
        this.montoMayores = montoMayores;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMontoMenores() {
        return montoMenores;
    }

    public double getMontoMayores() {
        return montoMayores;
    }
}
