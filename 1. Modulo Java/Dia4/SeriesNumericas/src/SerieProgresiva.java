public class SerieProgresiva<T extends Number> {
    private T valorInicial;
    private T valorActual;
    private T incremento;

    public SerieProgresiva(T valorInicial, T incremento) {
        this.valorInicial = valorInicial;
        this.incremento = incremento;
        this.valorActual = valorInicial;
    }

    public T siguienteValor() {
        valorActual = sumar(valorActual, incremento);
        return valorActual;
    }

    public void reiniciarSerie() {
        valorActual = valorInicial;
    }

    public void establecerValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    private T sumar(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() + b.longValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        }
        return null; // Se podría implementar manejo de otros tipos de datos
    }

    public void setIncremento(T incremento) {
        this.incremento = incremento;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }
}

