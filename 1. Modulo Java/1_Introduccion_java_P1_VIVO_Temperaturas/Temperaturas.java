public class Main
{
    public static void main (String[] args){
        int menor;
        int mayor;
        int indexMenor = 0;
        int indexMayor = 0;
        String[] cities = {"Londres","Madrid","New York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago","Lisboa","Tokio"};
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
        menor = matrizTemperaturas[0][0];
        mayor = matrizTemperaturas[0][1];
        for(int j = 0; j < 10; j++){
            if(matrizTemperaturas[j][0] < menor){
                menor = matrizTemperaturas[j][0];
                indexMenor = j;
            }
            if(matrizTemperaturas[j][1] > mayor){
                mayor = matrizTemperaturas[j][1];
                indexMayor = j;
            }
        }
        System.out.println("La mayor temperatura se registro en " + cities[indexMayor] + " con un valor de "+mayor);
        System.out.println("Mientras la menor temperatura se registro en " + cities[indexMenor] + " con un valor de "+menor);
    }
}
