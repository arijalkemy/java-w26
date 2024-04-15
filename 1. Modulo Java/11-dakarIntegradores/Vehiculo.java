public abstract class Vehiculo {
    private int velocidad;
    private int aceleracion;
    private int anguloGiro;
    private String patente;
    private int peso;
    private int ruedas;
    private double indiceGanador;

    public Vehiculo(int velocidad, int aceleracion, int anguloGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
        setIndiceGanador();

    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public void setIndiceGanador() {
        this.indiceGanador = (double)(velocidad * (aceleracion/2))/(double)(anguloGiro*(peso-(ruedas*100)));

    }

    public double getIndiceGanador() {
        return indiceGanador;
    }




}
