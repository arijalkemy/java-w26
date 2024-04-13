package SerieNumerica;

public class SerieEntera extends Prototipo {

    public SerieEntera(Integer serie) {
        super(serie);
    }

    @Override
    public Integer siguiente(){
        return  ( (Integer) this.serie * this.contador++ ) + (Integer) this.valorInicial;
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
