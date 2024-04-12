package org.example;

public class SerieUno extends Prototipo{
    private Integer valorInicial;
    private Integer serie; // se guarda la serie;

    private int contador;
    private Integer serieGuardado;
    public SerieUno() {
        valorInicial = 0;
        contador = 0;
    }

    public Integer devolverSerie(Integer serieASumar) {
        if(this.serie != serieASumar)
        {
            reiniciarSerie();
            serie = serieASumar;
        }
        if(contador == 0)
        {
            serieGuardado = valorInicial+serieGuardado + serieASumar;
        }
        else
        {
            serieGuardado = serieGuardado + serieASumar;
        }


        contador++;
        return serieGuardado;
    }

    public void establecerValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
        reiniciarSerie();
    }

    public void reiniciarSerie() {
        this.serieGuardado = 0;
        this.contador = 0;
    }


}
