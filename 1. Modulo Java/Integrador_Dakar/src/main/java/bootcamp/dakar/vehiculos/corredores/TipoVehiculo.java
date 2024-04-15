package bootcamp.dakar.vehiculos.corredores;

public class TipoVehiculo {
    
    private NombreVehiculo nombre;
    private double peso;
    private int cantidadDeRuedas;



    public TipoVehiculo(NombreVehiculo nombre, double peso, int cantidadDeRuedas) {
        this.nombre = nombre;
        this.peso = peso;
        this.cantidadDeRuedas = cantidadDeRuedas;
    }

    public boolean isType(NombreVehiculo nombre) {
        return this.nombre.equals(nombre);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getCantidadDeRuedas() {
        return cantidadDeRuedas;
    }

    public void setCantidadDeRuedas(int cantidadDeRuedas) {
        this.cantidadDeRuedas = cantidadDeRuedas;
    }

    public NombreVehiculo getNombre() {
        return nombre;
    }

    public void setNombre(NombreVehiculo nombre) {
        this.nombre = nombre;
    }

}
