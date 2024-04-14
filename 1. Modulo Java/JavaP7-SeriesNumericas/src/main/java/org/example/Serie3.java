package org.example;

public class Serie3<T extends Number> extends Prototipo<T>{

    @Override
    public Number regresaSiguienteValor() {
        this.setIndice(this.getIndice() + 1);
        return this.getValorInicial().floatValue() + (this.getIndice() * 3);
    }

    @Override
    public Number ejecutar(Integer iteracion) {
        return this.getValorInicial().floatValue() + (iteracion * 3);
    }

}
