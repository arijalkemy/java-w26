package bootcamp.spring.blog.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface IRepository<T>{
	Optional<T> save(T obj);
	Optional<T> findById(Integer id);
	List<T> findAll();
}
