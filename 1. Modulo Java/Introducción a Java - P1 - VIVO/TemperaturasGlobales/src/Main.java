public class Main {
    public static void main(String[] args){

    String[] ciudades = {
            "Londres",
            "Madrid",
            "Nueva York",
            "Buenos Aires",
            "Asuncion",
            "Sao Paulo",
            "Lima",
            "Santiago de Chile",
            "Lisboa",
            "Tokio"};

    int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int temperaturaMinima = temperaturas[0][0];
        int temperaturaMaxima = temperaturas[0][1];

        String ciudadMinimo = "";
        String ciudadMaximo = "";

        //recorro una a una las ciudades
        for (int ciudad = 0; ciudad < temperaturas.length; ciudad++) {

                //reviso si la temperatura de esta ciudad es mas baja que el minimo
                if (temperaturas[ciudad][0]<temperaturaMinima) {
                    temperaturaMinima = temperaturas[ciudad][0];
                    ciudadMinimo = ciudades[ciudad];
                }

                //reviso si la temperatura de esta ciudad es mas alta que el maximo
                if (temperaturas[ciudad][1]>temperaturaMaxima) {
                    temperaturaMaxima = temperaturas[ciudad][1];
                    ciudadMaximo = ciudades[ciudad];
                }
        }

        System.out.println("la temperatura minima fue: " + temperaturaMinima + "C en la ciudad de: " + ciudadMinimo );
        System.out.println("la temperatura maxima fue: " + temperaturaMaxima + "C en la ciudad de: " + ciudadMaximo );
    }
}
