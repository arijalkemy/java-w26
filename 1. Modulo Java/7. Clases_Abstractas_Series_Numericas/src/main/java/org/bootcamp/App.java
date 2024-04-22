package org.bootcamp;

public class App 
{
    public static void main( String[] args )
    {
        SerieDos serieDos = new SerieDos();
        System.out.println(serieDos.siguienteNumero());
        serieDos.establecerInicio(10);
        System.out.println(serieDos.siguienteNumero());
        System.out.println(serieDos.siguienteNumero());
        System.out.println(serieDos.siguienteNumero());

        serieDos.reiniciarSerie();
        System.out.println(serieDos.siguienteNumero());
        System.out.println(serieDos.siguienteNumero());

        System.out.println("***********");

        SerieFraccion serieFraccion = new SerieFraccion();
        System.out.println(serieFraccion.siguienteNumero());
        serieFraccion.establecerInicio(10.0);
        System.out.println(serieFraccion.siguienteNumero());
        System.out.println(serieFraccion.siguienteNumero());
        System.out.println(serieFraccion.siguienteNumero());

        serieFraccion.reiniciarSerie();
        System.out.println(serieFraccion.siguienteNumero());
        System.out.println(serieFraccion.siguienteNumero());
    }
}
