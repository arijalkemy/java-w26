//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.print("Hello and welcome!");

        int[][] matrizTemperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39}
        ,{7,26},{-1,31},{-10,35}};

        String[] countryArray = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción"
                ,"São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};


        // Busqueda de temperaturas
        int min = Integer.MAX_VALUE;
        int indexMin = 0;
        int max = 0;
        int indexMax = Integer.MIN_VALUE;
        for(int i = 0;i<matrizTemperaturas.length;i++){
            if(min>matrizTemperaturas[i][0]){
                min = matrizTemperaturas[i][0];
                indexMin = i;
            }
            if(max<matrizTemperaturas[i][1]){
                max = matrizTemperaturas[i][1];
                indexMax = i;
            }
        }
        // Mostrar información
        System.out.print("La menor temperatura la tuvo "+countryArray[indexMin]+" con "
        +min+" °C");
        System.out.print("\n");
        System.out.print("La mayor temperatura la tuvo "+countryArray[indexMax]+" con "
        +max+" °C");

    }
}