package co.com.mercadolibre;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                            "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        Integer[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43},
                                    {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        Integer indiceTemperaturaMaxima = 0;
        Integer indiceTemperaturaMinima = 0;
        Integer temperaturaMaxima = temperaturas[0][1];
        Integer temperaturaMinima = temperaturas[0][0];

        for (int i = 1; i < ciudades.length; i++) {
            if (temperaturas[i][1] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i][1];
                indiceTemperaturaMaxima = i;
            }
            if (temperaturas[i][0] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i][0];
                indiceTemperaturaMinima = i;
            }
        }
        System.out.println("La ciudad con la temperatura más alta es " + ciudades[indiceTemperaturaMaxima] +
                " con " + temperaturaMaxima + " °C.");
        System.out.println("La ciudad con la temperatura más baja es " + ciudades[indiceTemperaturaMinima] +
                " con " + temperaturaMinima + " °C.");
    }
}
