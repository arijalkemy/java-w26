package org.example;

import java.util.ArrayList;

public abstract class Prototipo <T extends Number>{

    private T valorInicial;

    private Integer indice;

    public Prototipo() {
        this.indice = 0;
        this.valorInicial = (T) Integer.valueOf(0) ;
    }

    public abstract Number ejecutar(Integer iteracion);

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract Number regresaSiguienteValor();

    public void reiniciarSerie() {
        this.indice = 0;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }
}
