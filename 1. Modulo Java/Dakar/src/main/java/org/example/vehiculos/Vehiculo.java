package org.example.vehiculos;

public class Vehiculo {

    protected Integer velocidad;
    protected Integer aceleracion;
    protected Double anguloDeGiro;
    protected String patente;
    protected Double peso;
    protected Integer ruedas;
    private TipoDeVehiculo tipoDeVehiculo;

    public Vehiculo(TipoDeVehiculo tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public Vehiculo(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public Double valorObtenidoRendimiento() {
        return (this.velocidad * (0.5 * this.aceleracion)) / (this.anguloDeGiro * (this.peso - (this.ruedas * 100)));
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}
