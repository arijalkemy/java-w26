package series;

public class SerieDe3 extends SerieNumerica<Integer> {
    public SerieDe3() {
        this.setValorInicial(Integer.valueOf(0));
        this.setValorActual(Integer.valueOf(0));
    }

    public Integer computarSiguiente() {
        Integer incremento = this.getValorActual() + Integer.valueOf(3);
        this.setValorActual(incremento);
        return this.getValorActual();
    }
}
