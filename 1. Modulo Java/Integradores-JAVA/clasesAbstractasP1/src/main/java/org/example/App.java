package org.example;

public class App 
{
    public static void main( String[] args )
    {
        SerieDos<Integer> serieDos = new SerieDos<>();
        SerieTres<Integer> serieTres = new SerieTres<>();
        serieDos.setValorInicial(2);

        // Ejemplo de serie de 2
        System.out.println("Serie de 2:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Siguiente valor: " + serieDos.nextValue());
        }

        // Reiniciar la serie de 2
        serieDos.reiniciarSerie();
        System.out.println("Serie de 2 reiniciada:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Siguiente valor: " + serieDos.nextValue());
        }

        // Establecer valor inicial de la serie de 3
        serieTres.setValorInicial(1);
        System.out.println("Serie de 3 con valor inicial 1:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Siguiente valor: " + serieTres.nextValue());
        }


    }
}
