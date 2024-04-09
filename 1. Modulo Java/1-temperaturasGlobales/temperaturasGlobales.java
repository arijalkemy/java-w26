public class temperaturasGlobales {
    public static void main(String[] args){
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Pablo", "Lima",
        "Santiago de Chile", "Lisboa", "Tokio"};

        int [][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int temperaturaMinima = 0;
        int temperaturaMaxima = 0;

        for (int i = 1; i < ciudades.length; i++){
            if (temperaturas[i][0] < temperaturas[temperaturaMinima][0]) {
                temperaturaMinima = i;
            }
            if (temperaturas[i][1] > temperaturas[temperaturaMaxima][1]) {
                temperaturaMaxima = i;
            }
        }
        System.out.println("La temperatura maxima es: " + temperaturas[temperaturaMaxima][1] + " perteneciente a " + ciudades[temperaturaMaxima]);
        System.out.println("La temperatura minima es: " + temperaturas[temperaturaMinima][0] + " perteneciente a " + ciudades[temperaturaMinima]);
    }
}
