package org.example;

public abstract class Series <T extends Number> {
    private int id;
    private boolean iniciada;
    private int iteracion;  //en que numero de iteracion va
    private T primerValor;
    private T valorActual;

    public Series(int id, T primerValor) {
        this.id = id;
        this.primerValor = primerValor;
        this.valorActual = primerValor;
        this.iniciada=false;
    }
    /**
     * reinicia la serie, el valor actual sera el primer valor ingresado
     */
    public void reiniciar() {
        this.iteracion = 0;
        this.valorActual=this.primerValor;
    }
    /**
     * @return T Devuelve cual sera el proximo numero si se ejecuta una vez la serie
     */
    public abstract T siguienteValor();
    /**
     * ejecutara N veces la serie debe mostrar un mensaje por cada ejecucion,
     * si es la primera vez debera setear el booleano iniciado en true
     */
    public abstract void ejercutarnVeces(int n);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIniciada() {
        return iniciada;
    }

    public void setIniciada(boolean iniciada) {
        this.iniciada = iniciada;
    }

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }

    public T getPrimerValor() {
        return primerValor;
    }

    public void setPrimerValor(T primerValor) {
        this.primerValor = primerValor;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }

    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", iniciada=" + iniciada +
                ", iteracion=" + iteracion +
                ", primerValor=" + primerValor +
                ", valorActual=" + valorActual +
                '}';
    }
}
