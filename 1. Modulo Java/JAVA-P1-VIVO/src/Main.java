public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        String [] ciudades = {"Londres"
                ,"Madrid"
                ,"Nueva York"
                ,"Buenos Aires"
                ,"Asunción"
                ,"Sao Paulo"
                ,"Lima"
                ,"Santiago de Chile"
                ,"Lisboa"
                ,"Tokio"};

        int temperaturas[][] = {
                {-2, -3, -8, 4, 6, 5, 0, -7, -1, -10},
                {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}
        };


        int temperaturaMaxima = temperaturas[0][0];
        int temperaturaMinima = temperaturas[1][0];
        String ciudadMinima = "";
        String ciudadMaxima = "";
        
        for(int i = 0; i<ciudades.length;i++){
            if(temperaturas[0][i]<temperaturaMinima){
                temperaturaMinima = temperaturas[0][i];
                ciudadMinima = ciudades[i];
            }

            if(temperaturas[1][i]>temperaturaMaxima){
                temperaturaMaxima = temperaturas[1][i];
                ciudadMaxima = ciudades[i];
            }
        }






        System.out.println("La temperatura minima es "+temperaturaMinima +" de la ciudad " + ciudadMinima);
        System.out.println("La temperatura maxima "+temperaturaMaxima + " de la ciudad " + ciudadMaxima);


    }

}