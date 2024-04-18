package bootcamp.spring.blog.service.interfaces;

import java.util.List;

public interface IService<T>{
    List<T> searchAll();
    T searchById(Integer id);
}
