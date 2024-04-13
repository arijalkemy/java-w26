package org.example.Impl;

import java.util.List;

public interface Crud <T>{

    public void altas( String fecha, T ... elemento );
    public List<T> consulta();

}
