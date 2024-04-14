public class SerieX3<T extends Number> extends Prototipo<T>{

    public SerieX3(T nroInicial) {
        super(nroInicial);
    }

    @Override
    public T devolverSiguiente() {
        T siguiente = getNroActual();
        if(siguiente instanceof Integer){
            siguiente = (T) Integer.valueOf(((Number) siguiente).intValue() + 3);
        } else if (siguiente instanceof Double) {
            siguiente = (T) Double.valueOf(((Number) siguiente).doubleValue() + 3);
        } else if (siguiente instanceof Float) {
            siguiente = (T) Float.valueOf(((Number) siguiente).floatValue() + 3);
        }
        setNroActual(siguiente);
        return siguiente;
    }
}
