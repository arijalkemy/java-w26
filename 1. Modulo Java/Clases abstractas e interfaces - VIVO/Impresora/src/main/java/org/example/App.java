package org.example;

public class App
{
    public static void main( String[] args )
    {
        Curriculum cv = new Curriculum("Juan", 30);
        Impresora impresora = new Impresora();
        impresora.imprimir(cv);
    }
}
