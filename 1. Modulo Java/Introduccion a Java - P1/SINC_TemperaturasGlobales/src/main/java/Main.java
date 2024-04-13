public class Main {
    public static void main(String[] args) {

        //Declaro el vector para las ciudades y matriz para las temperaturas
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo",
                            "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturaCiudades = {{-2,33}, {-3,32}, {-8, 27}, {4,37}, {6,42},
                                        {5,43}, {0,39}, {-7,26}, {-1,31}, {-10,35}};

        //Declaro las variables necesarias. Las ultimas las inicializo con las temperaturas
        // del primer registro para ir comparando
        int indiceMenorTemp = 0;
        int indiceMayorTemp = 0;
        int temperaturaMenor = temperaturaCiudades[0][0];
        int temperaturaMayor = temperaturaCiudades[0][1];

        //Recorro las filas de la matriz sabiendo de antemano que tiene 2 columnas
        for (int f=0; f < temperaturaCiudades.length; f++) {
            if (temperaturaCiudades[f][0] < temperaturaMenor) {
                temperaturaMenor = temperaturaCiudades[f][0];
                indiceMenorTemp = f;
            }
            if (temperaturaCiudades[f][1] > temperaturaMayor) {
                temperaturaMayor = temperaturaCiudades[f][1];
                indiceMayorTemp = f;
            }
        }

        //Muestro por consola los resultados
        System.out.println("La menor temperatura se registró en " + ciudades[indiceMenorTemp] +
                " con " + temperaturaCiudades[indiceMenorTemp][0] + " grados.");
        System.out.println("La mayor temperatura se registró en " + ciudades[indiceMayorTemp] +
                " con " + temperaturaCiudades[indiceMayorTemp][1] + " grados.");
    }
}
