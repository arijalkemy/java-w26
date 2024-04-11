public class matrices {
    public static void main(String[] args) {
    String ciudades[] = new String[] {
            "Londres","Madrid","Nueva York","Buenos Aires","Asunción","" +
            "Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
    int temperaturas[][] = new int[][] {
            {-2,33}, {-3,32},{-8,27}, {4,37},{6,42}, {5,43},{0,39}, {-7,26},{-1,31}, {-10,35}
    };
    int temperatura_min=0;
    int temperatura_max=0;
    int ciudad_max=0;
    int ciudad_min=0;
    for(int f = 0; f<ciudades.length; f++){
        if (temperaturas[f][0]<temperatura_min ){
            temperatura_min= temperaturas[f][0];
            ciudad_min = f;
        }
        if (temperaturas[f][1]>temperatura_max ){
            temperatura_max = temperaturas[f][1];
            ciudad_max = f;
        }
    }
        System.out.println("La ciudad con temperatura menor es: "+ciudades[ciudad_min] + " y su temperatura es: " + temperatura_min);
        System.out.println("La ciudad con temperatura mayor es: "+ciudades[ciudad_max] + " y su temperatura es: " + temperatura_max);
    }
}
