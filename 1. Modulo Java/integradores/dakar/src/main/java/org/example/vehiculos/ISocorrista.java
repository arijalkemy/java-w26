package org.example.vehiculos;

public interface ISocorrista<T extends Vehiculo> {
    void socorrer(T vehiculo);

    default String getPatente(T vehiculo){
        return vehiculo.getPatente();
    }
}
