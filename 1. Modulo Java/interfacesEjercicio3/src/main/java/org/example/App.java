package org.example;

public class App
{
    public static void main( String[] args )
    {
        Gato gato1 = new Gato("hinata");
        Vaca vaca1 = new Vaca("vaca1");
        Perro  perro1 = new Perro("perro1");

        gato1.emitirSonido();
        gato1.comerCarne();
        vaca1.emitirSonido();
        vaca1.comerHierba();
        perro1.emitirSonido();
        perro1.comerCarne();





    }
}
