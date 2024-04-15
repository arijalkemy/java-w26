public class Main {
    public static void main(String[] args) {
        SerieProgresiva<Integer> serieNum = new SerieProgresiva<>(0, 2);
        System.out.println("Serie progresiva de 2 en 2: ");
        probarSerie(serieNum);

        serieNum.reiniciarSerie();
        System.out.println("\nReiniciando la serie progresiva de 2 en 2:");
        probarSerie(serieNum);

        serieNum.establecerValorInicial(1);
        System.out.println("\nEstableciendo un nuevo valor inicial para la serie progresiva de 2 en 2:");
        probarSerie(serieNum);

        serieNum.setIncremento(3);
        System.out.println("\nCambiar incremento para que sea de 3 en 3:");
        probarSerie(serieNum);
    }

    public static void probarSerie(SerieProgresiva serieNum) {
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                System.out.println("Primer valor: " + serieNum.getValorActual());
            } else {
                System.out.println("Siguiente valor: " + serieNum.siguienteValor());
            }
        }
    }
}