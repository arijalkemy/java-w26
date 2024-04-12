package org.example.socorrista;

import org.example.vehiculo.Vehiculo;

public interface iSocorrista<T extends Vehiculo>{
    void socorrer(T vehiculo);
}
