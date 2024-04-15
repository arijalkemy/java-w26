package bootcamp.bendezujonathan.vehiculos.corredores;

public class Vehiculo {
    private float velocidad;
    private float aceleracion;
    private float anguloDeGiro;
    private String patente;
    private TipoVehiculo tipo;

    public Vehiculo(float velocidad, float aceleracion, float anguloDeGiro, String patente, TipoVehiculo tipo) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.tipo = tipo;
    }

    public double result() {
        return this.velocidad * this.aceleracion * 0.5 /
                (this.anguloDeGiro * (this.tipo.getPeso() - this.tipo.getCantidadDeRuedas() * 1000));
    }

    public boolean isType(NombreVehiculo nombre) {
        return this.tipo.isType(nombre);
    }

    

    @Override
    public String toString() {
        return "Vehiculo [velocidad=" + velocidad + ", aceleracion=" + aceleracion + ", anguloDeGiro=" + anguloDeGiro
                + ", patente=" + patente + ", tipo: "+ tipo.getNombre()+ "]";
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public float getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(float aceleracion) {
        this.aceleracion = aceleracion;
    }

    public float getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(float anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

}
