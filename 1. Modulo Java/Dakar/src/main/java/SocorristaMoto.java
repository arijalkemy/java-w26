public class SocorristaMoto extends Vehiculo {

    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
    }

    public void socorristaMoto(Moto moto)
    {
        System.out.println("socorriendo moto con patente: " + moto.getPatente());
    }
}
