public class Auto extends Vehiculo {
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.setPeso(1000);
        super.setCantidadRuedas(4);
    }
}
