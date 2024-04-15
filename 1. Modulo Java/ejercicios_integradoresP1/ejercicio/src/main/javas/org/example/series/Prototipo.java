package org.example.series;

public abstract class Prototipo<T extends Number> {

    public T serie;
    public T inciador;
    public T valorActual;

    public Prototipo(T serie, T inciador) {
        this.serie = serie;
        this.inciador = inciador;
        this.valorActual=inciador;
    }

    abstract T valorSiguiente();
    public void resetear(){
        this.valorActual=this.inciador;
    }
    public void ejecutarNVeces(int n){
        for (int i=0;i<n;i++){
            T value = valorSiguiente();
            System.out.println("El siguiente valor de la serie es: ");
            System.out.println(value);
        }
    }
}
