package supermercado;
import java.util.List;
public interface CRUD <T> {
    void agregar(T obj);
    void eliminar(T obj);
    void actualizar(T obj, T nuevoObj);
    T buscar(T obj);
    List<T> listar();
}
