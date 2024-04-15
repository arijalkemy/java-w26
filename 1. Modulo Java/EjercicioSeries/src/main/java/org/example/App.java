package org.example;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("PRUEBA SERIE DE 2");
        SerieDe2 serieDe2=new SerieDe2();
        serieDe2.valorInicial(1);

        for(int i=0;i<3;i++){
            System.out.println(serieDe2.numeroSiguiente());
        }

        serieDe2.reiniciarSerie();

        for(int i=0;i<3;i++){
            System.out.println(serieDe2.numeroSiguiente());
        }

        System.out.println("PRUEBA SERIE DE 7");
        SerieDe7 serieDe7=new SerieDe7();
        serieDe7.valorInicial(1);

        for(int i=0;i<3;i++){
            System.out.println(serieDe7.numeroSiguiente());
        }

        serieDe7.reiniciarSerie();

        for(int i=0;i<3;i++){
            System.out.println(serieDe7.numeroSiguiente());
        }
    }
}
