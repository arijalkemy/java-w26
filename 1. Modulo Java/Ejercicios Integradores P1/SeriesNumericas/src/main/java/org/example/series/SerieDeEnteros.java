package org.example.series;

public class SerieDeEnteros extends Serie<Integer> {

    public SerieDeEnteros(Integer incremento){
        this.incremento = incremento;
        this.valorActual = 0;
    }

    @Override
    public Integer siguiente() {
        this.valorActual += this.incremento;
        return this.valorActual;
    }

    @Override
    public void reiniciar() {
        this.valorActual = Integer.valueOf(0);
    }
}
