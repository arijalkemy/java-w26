package bootcamp.spring.deportistas.repositories;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
}
