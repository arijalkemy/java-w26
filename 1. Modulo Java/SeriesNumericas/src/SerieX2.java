public class SerieX2<T extends Number> extends Prototipo<T>{

    public SerieX2(T nroInicial) {
        super(nroInicial);
    }

    @Override
    public T devolverSiguiente() {
        T siguiente = getNroActual();
        if(siguiente instanceof Integer){
            siguiente = (T) Integer.valueOf(((Number) siguiente).intValue() + 2);
        } else if (siguiente instanceof Double) {
            siguiente = (T) Double.valueOf(((Number) siguiente).doubleValue() + 2);
        } else if (siguiente instanceof Float) {
            siguiente = (T) Float.valueOf(((Number) siguiente).floatValue() + 2);
        }
        setNroActual(siguiente);
        return siguiente;
    }
    }

