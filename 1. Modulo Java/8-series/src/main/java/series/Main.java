package series;

public class Main {
    public static void main(String[] args) {
        SerieNumerica<Float> serieDe2= new SerieDe2();

        System.out.println("Serie de 2:");
        System.out.println(serieDe2.computarSiguiente());
        System.out.println(serieDe2.computarSiguiente());
        System.out.println(serieDe2.computarSiguiente());
        System.out.println(serieDe2.computarSiguiente());

        System.out.println("Marco valor inicial a 1 y reinicio:");
        serieDe2.marcarInicio(Float.valueOf(1));
        serieDe2.reiniciarSerie();
        System.out.println(serieDe2.computarSiguiente());
        System.out.println(serieDe2.computarSiguiente());
        System.out.println(serieDe2.computarSiguiente());
        System.out.println(serieDe2.computarSiguiente());

        SerieNumerica<Integer> serieDe3 = new SerieDe3();

        System.out.println("Serie de 3:");
        System.out.println(serieDe3.computarSiguiente());
        System.out.println(serieDe3.computarSiguiente());
        System.out.println(serieDe3.computarSiguiente());
        System.out.println(serieDe3.computarSiguiente());

        System.out.println("Marco valor inicial a 1 y reinicio:");
        serieDe3.marcarInicio(Integer.valueOf(1));
        serieDe3.reiniciarSerie();
        System.out.println(serieDe3.computarSiguiente());
        System.out.println(serieDe3.computarSiguiente());
        System.out.println(serieDe3.computarSiguiente());
        System.out.println(serieDe3.computarSiguiente());
    }
}
