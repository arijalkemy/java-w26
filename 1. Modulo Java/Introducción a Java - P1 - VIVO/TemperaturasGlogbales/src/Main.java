public class Main {
    public static void main(String[] args) {
        String paises[]= new String[10];
        int temperaturas[][] = new int[10][2];

        paises[0] = "Londres";
        paises[1] = "Madrid";
        paises[2] = "Nueva York";
        paises[3] = "Buenos Aires";
        paises[4] = "Asuncion";
        paises[5] = "Sao Paulo";
        paises[6] = "Lima";
        paises[7] = "Santiago de Chile";
        paises[8] = "Lisboa";
        paises[9] = "Tokio";

        temperaturas[0][0] = -2;
        temperaturas[1][0] = -3;
        temperaturas[2][0] = -8;
        temperaturas[3][0] = 4;
        temperaturas[4][0] = 6;
        temperaturas[5][0] = 5;
        temperaturas[6][0] = 0;
        temperaturas[7][0] = -7;
        temperaturas[8][0] = -1;
        temperaturas[9][0] = -10;
        temperaturas[0][1] = 33;
        temperaturas[1][1] = 32;
        temperaturas[2][1] = 27;
        temperaturas[3][1] = 37;
        temperaturas[4][1] = 42;
        temperaturas[5][1] = 43;
        temperaturas[6][1] = 39;
        temperaturas[7][1] = 26;
        temperaturas[8][1] = 31;
        temperaturas[9][1] = 35;

        int paisTemperaturaMinima=0;
        int paisTemperaturaMaxima=0;
        for (int f=0;f< paises.length-1;f++){
            if (temperaturas[paisTemperaturaMinima][0]>temperaturas[f][0]){
                paisTemperaturaMinima=f;
            }
            if (temperaturas[paisTemperaturaMinima][1]<temperaturas[f][1]){
                paisTemperaturaMaxima=f;
            }
        }
        System.out.println("El pais con menor temperatura es: " +paises[paisTemperaturaMinima] +
                " con una temperatura de: " + temperaturas[paisTemperaturaMinima][0] + "°C");
        System.out.println("El pais con mayor temperatura es: " +paises[paisTemperaturaMaxima] +
                " con una temperatura de: " + temperaturas[paisTemperaturaMaxima][0] + "°C");
    }
}