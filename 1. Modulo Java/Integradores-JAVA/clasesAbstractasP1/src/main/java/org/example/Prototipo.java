package org.example;

public class Prototipo <T extends Number>  {
    private T valorActual;
    private T valorInicial;
    private T paso;

    public Prototipo(T paso){
        this.paso=paso;
        reiniciarSerie();
    }

    public T nextValue(){
        T next = this.valorActual;
        this.valorActual = sumar(this.valorActual, this.paso);
        return next;
    }

    public void reiniciarSerie(){
        this.valorActual=this.valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }


    private T sumar(T valorActual, T paso) {

        if (valorActual instanceof Integer) {
            return (T) Integer.valueOf(valorActual.intValue() + paso.intValue());
        } else if (valorActual instanceof Double) {
            return (T) Double.valueOf(valorActual.doubleValue() + paso.doubleValue());
        } else if (valorActual instanceof Float) {
            return (T) Float.valueOf(valorActual.floatValue() + paso.floatValue());
        } else if (valorActual instanceof Long) {
            return (T) Long.valueOf(valorActual.longValue() + paso.longValue());
        }
        else{
            throw new IllegalArgumentException("Tipo de dato no valido");
        }
    }

}
