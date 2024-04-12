package meli.bootcamp.ClasesAbstractas;

public class Main {
    public static void main(String[] args) {
        SecuenciaEnDos secuenciaEnDos = new SecuenciaEnDos();

        System.out.println(secuenciaEnDos.valorSiguiente());
        System.out.println(secuenciaEnDos.valorSiguiente());
        System.out.println(secuenciaEnDos.valorSiguiente());

        secuenciaEnDos.reiniciar();
        System.out.println(secuenciaEnDos.valorSiguiente());

        secuenciaEnDos.seteaValorInicial(1);
        System.out.println(secuenciaEnDos.valorSiguiente());
        System.out.println(secuenciaEnDos.valorSiguiente());

        System.out.println("\n----------------------------------\n");

        SecuenciaEnTres secuenciaEnTres = new SecuenciaEnTres();

        System.out.println(secuenciaEnTres.valorSiguiente());
        System.out.println(secuenciaEnTres.valorSiguiente());
        System.out.println(secuenciaEnTres.valorSiguiente());

        secuenciaEnTres.reiniciar();
        System.out.println(secuenciaEnTres.valorSiguiente());

        secuenciaEnTres.seteaValorInicial(5);
        System.out.println(secuenciaEnTres.valorSiguiente());
        System.out.println(secuenciaEnTres.valorSiguiente());
    }
}
