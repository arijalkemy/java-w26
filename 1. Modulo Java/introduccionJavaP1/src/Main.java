//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String [] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago", "Lisboa", "Tokio"};
        int [][] tempCiudades  = {{-2,33}, {-3,32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39}, {-7,26}, {-1,31}, {-10,35}};

        int tempMayor = tempCiudades[0][1];
        int tempMenor = tempCiudades[0][0];
        int indiceMenor = 0;
        int indiceMayor = 0;


        for (int i = 1; i < tempCiudades.length; i++){
            if (tempCiudades[i][0]< tempMenor) {
                indiceMenor =  i;
                tempMenor = tempCiudades[i][0];
            }
            if (tempCiudades[i][1] > tempMayor) {
                indiceMayor =  i;
                tempMayor = tempCiudades[i][1];
            }

        }
        System.out.println("La menor temperatura la tuvo " + ciudades[indiceMenor] +
                " con " + tempMenor +  " y la mayor temperatura la tuvo " + ciudades[indiceMayor] + " con " + tempMayor  );
    }
}

