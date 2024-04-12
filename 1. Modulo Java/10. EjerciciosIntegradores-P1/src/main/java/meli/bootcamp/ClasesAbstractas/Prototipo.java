package meli.bootcamp.ClasesAbstractas;

public abstract class Prototipo<T> {

    protected double valorInicial = 0;

    public abstract T valorSiguiente();

    public void reiniciar() {
        valorInicial = 0;
        System.out.println("Se reinicio el valor inicial a " + valorInicial);
    }

    public void seteaValorInicial(double valor) {
        valorInicial = valor;
        System.out.println("Se seteo el valor inicial a " + valorInicial);
    }
}
