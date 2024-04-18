public class Main {
    public static void main(String[] args) {

        String ciudades[] = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperatura = new int[][]{{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int mayorTemperatura = 0;
        int menorTemperatura = 0;
        String nombreMayor = "";
        String nombreMenor = "";
        boolean first = true;

        for (int f = 0; f <= 9; f++) {
            for (int c = 0; c <= 2; c++) {
                if (first == true) {
                    menorTemperatura = temperatura[f][0];
                    mayorTemperatura = temperatura[f][1];
                    first = false;
                } else if (menorTemperatura > temperatura[f][0]) {
                    nombreMenor = ciudades[f];
                    menorTemperatura = temperatura[f][0];
                }
                if (mayorTemperatura < temperatura[f][1]) {
                    mayorTemperatura = temperatura[f][1];
                    nombreMayor = ciudades[f];
                }
            }
        }
        System.out.println("La ciudad con menor temperatura fue: " + nombreMenor + " con una temperatura de: " + menorTemperatura);
        System.out.println("La ciudad con mayor temperatura fue: " + nombreMayor + " con una temperatura de: " + mayorTemperatura);
    }
}