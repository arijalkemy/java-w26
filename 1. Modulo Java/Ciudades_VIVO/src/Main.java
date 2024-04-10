public class Main {
    public static void main(String[] args) {

        String ciudades[] = {"Londres","Madrid","New York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int temp_baja = 0;
        int temp_alta = 0;
        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < temperaturas[temp_baja][0]) {
                temp_baja = i;
            }
            if (temperaturas[i][1] > temperaturas[temp_alta][1]) {
                temp_alta = i;
            }
        }
        System.out.println("La ciudad con la menor temperatura fue "+ciudades[temp_baja]+" con una temperatura de "+temperaturas[temp_baja][0]+" grados");
        System.out.println("La ciudad con la mayor temperatura fue "+ciudades[temp_alta]+" con una temperatura de "+temperaturas[temp_alta][1]+" grados");
    }
}