package meli.bootcamp.ClasesAbstractas;

public class SecuenciaEnDos extends Prototipo<Double>{

    @Override
    public Double valorSiguiente() {
        return valorInicial += 2;
    }

}
