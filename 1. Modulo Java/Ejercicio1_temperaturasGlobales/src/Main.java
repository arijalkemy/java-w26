//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Se inicializan las variables que se van a usar en la clase, en este caso indices para almacenar y comparar valores
        int indMax = 0;
        int indMin = 0;
        //Se realiza la carga de los datos a los vectores y matrices como se solicito
        String[] ciudades= {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas= {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        //Se realiza un ciclo for para poder recorrer la matriz y realizar la seleccion del valor maximo y minimo de cada ciudad
        for (int i = 1; i < ciudades.length; i++) {
            if(temperaturas[i][0] < temperaturas[indMin][0]){
                indMin = i;
            }
            if(temperaturas[i][1] > temperaturas[indMax][1]){
                indMax = i;
            }
        }
        //Se imprime la respuesta para que sea visible al usuario
        System.out.println("La ciudad con mayor temperatura es: "+ciudades[indMax]+" con una temperatura de: "+temperaturas[indMax][1]);
        System.out.println("La ciudad con menor temperatura es: "+ciudades[indMin]+" con una temperatura de: "+temperaturas[indMin][0]);
    }
}