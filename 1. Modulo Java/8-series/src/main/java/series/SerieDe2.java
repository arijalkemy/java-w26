package series;

public class SerieDe2 extends SerieNumerica<Float> {
    public SerieDe2() {
        this.setValorInicial(Float.valueOf(0));
        this.setValorActual(Float.valueOf(0));
    }

    public Float computarSiguiente() {
        Float incremento = this.getValorActual() + Float.valueOf(2);
        this.setValorActual(incremento);
        return this.getValorActual();
    }
}