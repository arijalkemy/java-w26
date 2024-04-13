public class Main {
    public static void main(String[] args) {
        Prototipo<Integer> serieDeDos = new SerieProgresivaInt(2, 2);
        System.out.println("Serie de dos:");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieDeDos.getValorSiguiente());
        }

        Prototipo<Integer> serieDeUno = new SerieProgresivaInt(0, 1);
        System.out.println("\nSerie de uno:");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieDeUno.getValorSiguiente());
        }

        Prototipo<Integer> serieDeTres = new SerieProgresivaInt(3, 3);
        System.out.println("\nSerie de tres:");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieDeTres.getValorSiguiente());
        }
    }

    }