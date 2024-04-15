public abstract class Vehiculo {
    private int velocidad;
    private int aceleracion;
    private int anguloDeGiro;
    private String patente;
    private int peso;
    private int ruedas;

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public Vehiculo setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        return this;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public Vehiculo setAceleracion(int aceleracion) {
        this.aceleracion = aceleracion;
        return this;
    }

    public int getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public Vehiculo setAnguloDeGiro(int anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
        return this;
    }

    public String getPatente() {
        return patente;
    }

    public Vehiculo setPatente(String patente) {
        this.patente = patente;
        return this;
    }

    public int getPeso() {
        return peso;
    }

    public Vehiculo setPeso(int peso) {
        this.peso = peso;
        return this;
    }

    public int getRuedas() {
        return ruedas;
    }

    public Vehiculo setRuedas(int ruedas) {
        this.ruedas = ruedas;
        return this;
    }
}
