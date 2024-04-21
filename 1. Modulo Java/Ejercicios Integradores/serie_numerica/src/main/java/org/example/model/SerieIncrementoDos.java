package org.example.model;

public class SerieIncrementoDos<T extends Number> extends Prototipo<T>{

    @Override
    public T valorSiguiente() {
        try {
            if (super.getValorActual() instanceof Integer) {
                super.setValorActual((T) Integer.valueOf(super.getValorActual().intValue() + 2));
            } else if (super.getValorActual() instanceof Double) {
                super.setValorActual((T) Double.valueOf(super.getValorActual().doubleValue() + 2));
            } else if (super.getValorActual() instanceof Float) {
                super.setValorActual((T) Float.valueOf(super.getValorActual().floatValue() + 2));
            } else if (super.getValorActual() instanceof Long) {
                super.setValorActual((T) Long.valueOf(super.getValorActual().longValue() + 2));
            } else if (super.getValorActual() instanceof Short) {
                super.setValorActual((T) Short.valueOf((short) (super.getValorActual().shortValue() + 2)));
            } else if (super.getValorActual() instanceof Byte) {
                super.setValorActual((T) Byte.valueOf((byte) (super.getValorActual().byteValue() + 2)));
            }
        }catch (ClassCastException e) {
            System.out.println("El valor no corresponde a uno de clase Number");
        }
        return super.getValorActual();
    }

}
