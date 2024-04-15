public class SocorrerAuto implements Socorrista<Auto> {
    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo Auto" + vehiculo.getPatente());
    }
}
