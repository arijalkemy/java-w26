public class MatrizTemperatura{

    public static void main (String[] args) {

        String cityVectors [] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paolo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas [][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int maxTemp = Integer.MIN_VALUE;
        int minTemp = Integer.MAX_VALUE;
        String cityMinTemp = "";
        String cityMaxTemp = "";


        for (int i = 0; i < temperaturas.length ; i ++) {
            if (temperaturas[i][0] < minTemp){
                minTemp = temperaturas[i][0];
                cityMinTemp = cityVectors[i];
            } 

            if (temperaturas[i][1] > maxTemp){
                maxTemp = temperaturas[i][1];
                cityMaxTemp = cityVectors[i];
            } 
        }

        System.out.println("La ciudad con menor temp " + cityMinTemp + " con temp: " + minTemp);

        System.out.println("La ciudad con mayor temp " + cityMaxTemp + " con temp: " + maxTemp);
    }
}