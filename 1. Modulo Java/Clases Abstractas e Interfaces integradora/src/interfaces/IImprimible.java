package interfaces;

public interface IImprimible<T>{
    public default void imprimir(T doc){
        System.out.println(doc);
    }
}
