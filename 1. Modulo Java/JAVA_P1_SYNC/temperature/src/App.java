public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String ciudades [] = new String[10];
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

        int matriz_temperaturas[][] = new int[10][2];
           
        matriz_temperaturas[0][0] = -2;
        matriz_temperaturas[1][0] = -3;
        matriz_temperaturas[2][0] = -8;
        matriz_temperaturas[3][0] = 4;
        matriz_temperaturas[4][0] = 6;
        matriz_temperaturas[5][0] = 5;
        matriz_temperaturas[6][0] = 0;
        matriz_temperaturas[7][0] = -7;
        matriz_temperaturas[8][0] = -1;
        matriz_temperaturas[9][0] = -10;

        matriz_temperaturas[0][1] = 33; 
        matriz_temperaturas[2][1] = 32; 
        matriz_temperaturas[3][1] = 37; 
        matriz_temperaturas[4][1] = 42; 
        matriz_temperaturas[5][1] = 43; 
        matriz_temperaturas[6][1] = 39; 
        matriz_temperaturas[7][1] = 26; 
        matriz_temperaturas[8][1] = 31; 
        matriz_temperaturas[8][1] = 35; 
        
        int mt_i = 0;
        int mmt_i = 0;

        int temperatura_mayor = matriz_temperaturas[mt_i][1]; 
        int temperatura_menor = matriz_temperaturas[mmt_i][0];
 
        for (int i = 0; i < matriz_temperaturas.length; i++) {
            if (matriz_temperaturas[i][0] < temperatura_menor) {
                temperatura_menor = matriz_temperaturas[i][0];
                mmt_i = i;
            }

            if (matriz_temperaturas[i][1] > temperatura_mayor) {
                temperatura_mayor = matriz_temperaturas[i][1];
                mt_i = i;
            }
        }


        System.out.println("La mayor temperatura la tiene la ciudad: " + ciudades[mt_i] + " con una temperatura de: " + matriz_temperaturas[mt_i][1]);
        System.out.println("La menor temperatura la tiene la ciudad: " + ciudades[mmt_i] + " con una temperatura de: " + matriz_temperaturas[mmt_i][0]);
    
    }
}
