public class Temperaturas {
    public static void main(String[] args) {

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, -33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        String ciudadMenor = ciudades[0];
        String ciudadMayor = ciudades[0];
        int temperaturaMenor = temperaturas[0][0];
        int temperaturaMayor = temperaturas[0][1];

        for (int i = 0; i < ciudades.length; i++) {
            System.out.println(ciudades[i] + "\n\t Temperatura más baja: \t" + temperaturas[i][0]
                    + "\n\t Temperatura más alta: \t" + temperaturas[i][1]);
            if (temperaturaMenor > temperaturas[i][0]) {
                ciudadMenor = ciudades[i];
                temperaturaMenor = temperaturas[i][0];
            }
            if (temperaturaMayor < temperaturas[i][1]) {
                ciudadMayor = ciudades[i];
                temperaturaMayor = temperaturas[i][1];
            }
        }

        System.out.println("\n\nMenor: " + ciudadMenor + " - " + temperaturaMenor);
        System.out.println("Mayor: " + ciudadMayor + " - " + temperaturaMayor);
    }
}