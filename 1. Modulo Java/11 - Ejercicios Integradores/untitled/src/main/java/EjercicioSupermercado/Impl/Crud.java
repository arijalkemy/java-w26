package EjercicioSupermercado.Impl;

import java.util.List;

public interface Crud <T>{

    public void altas( T ... elemento );

    public List<T> consulta();

    public void bajas( T elemento );

    public void modificacion( T elemento );
}
