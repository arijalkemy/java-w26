public class EjercicioP1 {
    public static void main(String[] args) {
        int[][] temperaturas = { { -2,33}, {-3,32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39}, {-7,26}, {-1,31}, {-10,35}};
        String[] ciudades = {"Londres", "Madrid","Nueva York","Buenos Aires","Asuncion", "Sao Paulo", "Lima", "Santiago de Chile","Lisboa","Tokio"};
        int indMayor=0;
        int indMenor=0;
        int mayor=temperaturas[0][1] ;
        int menor=temperaturas[0][0];

        for(int f=0;f<ciudades.length;f++){
            for(int c=0;c<2;c++){
                switch(c){
                    case 0:
                        if(temperaturas[f][c]<menor){
                            menor = temperaturas[f][c];
                            indMenor = f;
                        }
                        break;
                    case 1:
                        if(temperaturas[f][c]>mayor){
                            mayor = temperaturas[f][c];
                            indMayor = f;
                        }
                        break;
                }
            }
        }

        System.out.println("La mayor temperatura se presento en "+ciudades[indMayor]+" y fue de "+mayor+" grados");
        System.out.println("La menor temperatura se presento en "+ciudades[indMenor]+" y fue de "+menor+" grados");

    }
}
