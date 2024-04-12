package org.example.series;

public class SerieDeDoubles extends Serie<Double>{
    public SerieDeDoubles(Double incremento){
        this.incremento = incremento;
        this.valorActual = Double.valueOf(0);
    }
    @Override
    public Double siguiente() {
        this.valorActual += this.incremento;
        return this.valorActual;
    }

    @Override
    public void reiniciar() {
        this.valorActual = Double.valueOf(0);
    }
}
