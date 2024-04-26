package Repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {
    public void save(T object);

    public void showScreen();

    public Optional<T> loockFor(Long id);

    public void delete(Long id);

    public List<T> getAll();
}
