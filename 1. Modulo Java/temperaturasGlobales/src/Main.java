//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] vectorCiudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion",
                "Sao Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };

        int[][] matrizTemperaturas = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}
        };

        int mayor = 0;
        int posicionMayor = 0;
        int menor = matrizTemperaturas[0][0];
        int posicionMenor = 0;

        for (int i = 0; i<10; i++){
            if(matrizTemperaturas[i][0] < menor){
                menor = matrizTemperaturas[i][0];
                posicionMenor = i;
            }
            if(matrizTemperaturas[i][1] > mayor) {
                mayor = matrizTemperaturas[i][1];
                posicionMayor = i;
            }
        }

        System.out.println("La menor temperatura la tuvo " + vectorCiudades[posicionMenor] + ", con " + menor +"° C.");
        System.out.println("La mayor temperatura la tuvo " + vectorCiudades[posicionMayor] + ", con " + mayor +"° C.");
    }
}