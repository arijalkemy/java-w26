public class Temperaturas_EjercicioVIVO {

    //declaro variables
    private String[] ciudades;
    private int[][] temperaturas;

    public void temperaturas() {
//recargo el array y la matriz

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        temperaturas = new int[][]{
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int temperaturaMaxima = temperaturas[0][1];
        int temperaturaMinima = temperaturas[0][0];
        String ciudadMaxima = ciudades[0];
        String ciudadMinima = ciudades[0];


        for (int i = 1; i < ciudades.length; i++) {
            if (temperaturas[i][1] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i][1];
                ciudadMaxima = ciudades[i];
            }
            if (temperaturas[i][0] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i][0];
                ciudadMinima = ciudades[i];
            }
        }

        System.out.println("La temperatura máxima registrada fue " + temperaturaMaxima + " ºC en " + ciudadMaxima + ".");
        System.out.println("La temperatura mínima registrada fue " + temperaturaMinima + " ºC en " + ciudadMinima + ".");
    }


}
