
public class Main {
    private static int temperaturaMin = 0;
    private static int temperaturaMax = 1;

    private static String CIUDADES[] = {"Londres", "Madrid", "Nueva York",
            "Buenos Aires", "Asunción", "São Paulo",
            "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

    private static int TEMPERATURAS[][] = {{-2, 33}, {-3, 32}, {-8, 27},
            {4, 37}, {6, 42}, {5, 43},
            {0, 39}, {-7, 26} ,{-1, 31}, {-10, 35}};

    public static void main(String[] args){

        int indiceCiudadMayorTemperatura = 0;
        int indiceCiudadMenorTemperatura = 0;

        for(int i = 0; i < CIUDADES.length; i++) {
            if(TEMPERATURAS[indiceCiudadMayorTemperatura][temperaturaMax] < TEMPERATURAS[i][temperaturaMax]){
                indiceCiudadMayorTemperatura = i;
            }
            if(TEMPERATURAS[indiceCiudadMenorTemperatura][temperaturaMin] > TEMPERATURAS[i][temperaturaMin]) {
                indiceCiudadMenorTemperatura = i;
            }
        }

        System.out.println("La temperatura mayor es de " + TEMPERATURAS[indiceCiudadMayorTemperatura][temperaturaMax]
                                                         + "en la ciudad de" + CIUDADES[indiceCiudadMayorTemperatura]);
        System.out.println("La temperatura menor es de " + TEMPERATURAS[indiceCiudadMenorTemperatura][temperaturaMin]
                                                         + "en la ciudad de" + CIUDADES[indiceCiudadMenorTemperatura]);
    }
}
