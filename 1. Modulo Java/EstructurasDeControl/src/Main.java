//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] ciudades = new String[]{"Londres","Madrid","Nueva York","Buenos Aires","Asunción",
        "Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = new int[][]{new int[]{-2,33}, new int[]{-3,32}, new int[]{-8,27}, new int[]{4,37},new int[]{6,42},
                new int[]{5,43}, new int[]{0,39}, new int[]{-7, 26}, new int[]{-1,31}, new int[]{-10,35}};
        int[] min = new int[]{0, temperaturas[0][0]};
        int[] max = new int[]{0, temperaturas[0][1]};
        for(int i = 1; i < temperaturas.length; i++){
            if(temperaturas[i][0] < min[1]){
                min[0] = i;
                min[1] = temperaturas[i][0];
            }
            if(temperaturas[i][1] > max[1]){
                max[0] = i;
                max[1] = temperaturas[i][1];
            }
        }
        System.out.println("Ciudad con temperatura menor: "+ciudades[min[0]]);
        System.out.println("Ciudad con temperatura mayor: "+ciudades[max[0]]);
    }
}