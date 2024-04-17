public class Main {
    public static void main(String[] args) {

        int numeroIteraciones = 4;

        SerieInteger serieInteger = new SerieInteger(0,2,0);
        System.out.println("Serie de 2 (iniciando en 0):");
        for (int i = 0; i < numeroIteraciones; i++) {
            System.out.println(serieInteger.obtenerValorSiguiente());
        }

        serieInteger.establecerValorInicial(1);
        System.out.println("\nSerie de 2 (iniciando en 1):");
        for (int i = 0; i < numeroIteraciones; i++) {
            System.out.println(serieInteger.obtenerValorSiguiente());
        }

        serieInteger.setIncrementoSerie(3);
        serieInteger.setInicioSerie(0);
        serieInteger.reiniciarSerie();
        System.out.println("\nSerie de 3 (iniciando en 0):");
        for (int i = 0; i < numeroIteraciones; i++) {
            System.out.println(serieInteger.obtenerValorSiguiente());
        }

        SerieDouble serieDouble = new SerieDouble(0.0, 1.5, 0.0);
        System.out.println("\nSerie de 1.5 (iniciando en 0):\n");
        for (int i = 0; i < numeroIteraciones; i++) {
            System.out.println(serieDouble.obtenerValorSiguiente());
        }
    }
}
