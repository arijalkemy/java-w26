public class IntroJava_Ejercicio1 {
    public static void main(String[] args) {
        //Ejercicio

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
       
    int[][] temperaturas = {
        {-2, 33},
        {-3, 32},
        {-8, 27},
        {4, 37},
        {6, 42},
        {5,43},
        {0,39},
        {-7,26},
        {-1,31},
        {-10,35}
    };

    int tempMax = 0;
    int tempMin = 0;
    String CiudadMax = "";
    String CiudadMin = "";


    for(int i= 0; i< ciudades.length ; i++)
    {
        for(int j= 0; j<temperaturas[j].length ; j++)
        {
            int aux = temperaturas[i][j];
            if(aux > tempMax){
                tempMax = aux;
                CiudadMax = ciudades[i];
            }
            if(aux < tempMin)
            {
                tempMin = aux;
                CiudadMin = ciudades[i];
            }
        }
    }


    System.out.println("La ciudad con la temperatura más alta es: " + CiudadMax + " con " + tempMax + " grados");
    System.out.println("La ciudad con la temperatura más baja es: " + CiudadMin + " con " + tempMin + " grados");
         
    }
}