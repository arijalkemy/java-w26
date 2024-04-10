package entry;

public class Entry{
    public static void main(String[] args){
        String[] cities = fillArrayOfCities();
        int[][] temperatures = fillTemperaturesMatrix();

        int highestTemperature = temperatures[0][1];
        String cityHighestTemperature = cities[0];

        int lowestTemperature = temperatures[0][0];
        String cityLowestTemperature = cities[0];

        for(int i = 0; i < temperatures.length; i++){
            if(temperatures[i][1] > highestTemperature){
                highestTemperature = temperatures[i][1];
                cityHighestTemperature = cities[i];
            }
            if(temperatures[i][0] < lowestTemperature){
                lowestTemperature = temperatures[i][0];
                cityLowestTemperature = cities[i];
            }
        }

        System.out.println("Resultados");
        System.out.println(
            String.format("Temperatura mas alta: City %s - %d", cityHighestTemperature, highestTemperature)
            );
        System.out.println(
            String.format("Temperatura mas baja: City %s - %d", cityLowestTemperature, lowestTemperature)
            );

    }

    public static int[][] fillTemperaturesMatrix(){
        return new int[][]{
            {-2, 33}, 
            {-3, 32}, 
            {-8, 27}, 
            {4, 37}, 
            {6, 42}, 
            {5, 43}, 
            {0, 39}, 
            {-7, 26}, 
            {-1, 31}, 
            {-10, 35}
        };
    }

    public static String[] fillArrayOfCities(){
        return new String[]{"Londres" , "Madrid","Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
    }
}