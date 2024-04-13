package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Entero ent = new Entero(2);
        System.out.println("------ Primer escenario ------ ");
        ent.iniciarSerie(0);
        System.out.println("Valor inicial: " + ent.getValorInicial());
        for (int i = 0; i < 4; i++) {
            ent.valorSiguiente();
            System.out.println(ent.getValorActual());
        }
        ent.reiniciarSerie();
        System.out.println("Reiniciando serie - valor actual: " + ent.getValorActual());

        Flotante flot = new Flotante(2);
        System.out.println("------ Segundo escenario ------ ");
        flot.iniciarSerie(1);
        System.out.println("Valor inicial: " + flot.getValorInicial());
        for (int i = 0; i < 4; i++) {
            flot.valorSiguiente();
            System.out.println(flot.getValorActual());
        }
        flot.reiniciarSerie();
        System.out.println("Reiniciando serie - valor actual: " + flot.getValorActual());

        Entero ent2 = new Entero(3);
        System.out.println("------ Tercer escenario ------ ");
        ent2.iniciarSerie(0);
        System.out.println("Valor inicial: " + ent2.getValorInicial());
        for(int i=0; i< 4; i++) {
            ent2.valorSiguiente();
            System.out.println(ent2.getValorActual());
        }
        ent2.reiniciarSerie();
        System.out.println("Reiniciando serie - valor actual: " + ent2.getValorActual());

    }
}
