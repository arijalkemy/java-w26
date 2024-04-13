package SerieNumerica;

public class SerieDecimal extends Prototipo {

    public SerieDecimal(Double serie) {
        super(serie);
    }

    @Override
    public Double siguiente(){
        return  ( (Double) this.serie * this.contador++ ) +  this.valorInicial.doubleValue();
    }

    @Override
    public void valorInicial(Number valor) {
        super.valorInicial(valor);
    }

    @Override
    public void imprimirSerie(int n) {
        super.imprimirSerie(n);
    }
}

