package meli.bootcamp.ClasesAbstractas;

public class SecuenciaEnTres extends Prototipo<Double> {
    @Override
    public Double valorSiguiente() {
        return valorInicial += 3;
    }

}
