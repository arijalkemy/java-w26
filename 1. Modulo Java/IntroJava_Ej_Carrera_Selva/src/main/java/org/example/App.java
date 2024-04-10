package org.example;

public class App 
{
    public static void main( String[] args )
    {
        bienvenida();
        Loader.load();
        mostrarInscriptosPorCategoria(Loader.obtenerCategoriaAlAzar());
        desinscribirParticipante();
        calcularMontos();
    }

    public static void bienvenida(){
        System.out.println("| Bienvenidos al programa de la carrera de la selva |");
    }

    public static void mostrarInscriptosPorCategoria(Categoria categoria){
        System.out.printf("<< Se muestran a continuacion los inscriptos a la categoria '%s'%n",categoria.getNombre());
        for(Inscripcion inscripcion : Loader.INSCRIPCIONES){
            if(categoria.equals(inscripcion.getCategoria())){
                System.out.println(inscripcion);
            }
        }
    }

    public static void desinscribirParticipante(){
        System.out.println("<< Se desinscribira un participante al azar...");
        Inscripcion inscripcion = Loader.desinscribirParticipante();
        if(inscripcion == null){
            System.out.println("El participante no tenia una inscripcion asociada");
        }
        else{
            mostrarInscriptosPorCategoria(inscripcion.getCategoria());
        }
    }

    public static void calcularMontos(){
        int montoTotal = 0;
        for(Categoria categoria : Loader.CATEGORIAS){
            int montoCategoria = categoria.getMontoTotal();
            System.out.printf("<< El monto total por la categoria %s es de $%d%n",categoria.getNombre(),montoCategoria);
            montoTotal += categoria.getMontoTotal();
        }
        System.out.printf("El monto total acumulado entre todas las categorias es de $%d%n",montoTotal);
    }
}
