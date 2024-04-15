public class SocorristaAuto extends Vehiculo{

    public SocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

    public void socorristaAuto(Auto auto)
    {
        System.out.println("socorriendo auto con patente: " + auto.getPatente());
    }
}
