import com.sun.security.jgss.GSSUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nueva instancia secuencia dos en dos.");
        SerieX2 serie1 = new SerieX2(0);
        System.out.println(serie1.getNroInicial());
        System.out.println(serie1.devolverSiguiente());
        System.out.println(serie1.devolverSiguiente());
        System.out.println(serie1.devolverSiguiente());


        System.out.println("-- Se establece el valor inicial a 1 --");
        serie1.establecerValorInicialSerie(1);
        System.out.println(serie1.devolverSiguiente());
        System.out.println(serie1.devolverSiguiente());
        System.out.println(serie1.devolverSiguiente());
        System.out.println(serie1.devolverSiguiente());

        System.out.println("-- Se reinicia la serie al valor inicial. --");
        serie1.reiniciarSerie();
        System.out.println(serie1.getNroActual());

        System.out.println("/// Nueva instancia serie de 3 en 3 -----");
        SerieX3 serie3 = new SerieX3(0);
        System.out.println(serie3.devolverSiguiente());
        System.out.println(serie3.devolverSiguiente());
        System.out.println(serie3.devolverSiguiente());
        System.out.println(serie3.devolverSiguiente());

        System.out.println("-- Se establece numero inicial en 30 --");
        serie3.establecerValorInicialSerie(30);
        System.out.println(serie3.devolverSiguiente());;
        System.out.println(serie3.devolverSiguiente());
        System.out.println(serie3.devolverSiguiente());

        System.out.println("-- Reiniciar a numero inicial --");
        serie3.reiniciarSerie();
        System.out.println(serie3.nroActual);



    }
}