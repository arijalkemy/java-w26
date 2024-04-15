public class SocorrerMoto implements Socorrista<Moto> {
    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo Moto" + vehiculo.getPatente());
    }
}
