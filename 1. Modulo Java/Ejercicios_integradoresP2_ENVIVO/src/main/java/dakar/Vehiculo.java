package dakar;

public class Vehiculo {
    double velocidad=0;
    double aceleracion=0;
    double anguloDeGiro=0;
    String patente;
    double peso;
    int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }
}
