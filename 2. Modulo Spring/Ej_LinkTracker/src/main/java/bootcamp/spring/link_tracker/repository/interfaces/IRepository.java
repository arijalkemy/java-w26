package bootcamp.spring.link_tracker.repository.interfaces;

public interface IRepository<T>{
    T findById(Integer id);
}
