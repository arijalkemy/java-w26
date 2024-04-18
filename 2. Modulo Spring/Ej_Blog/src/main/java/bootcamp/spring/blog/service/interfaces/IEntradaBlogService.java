package bootcamp.spring.blog.service.interfaces;

import bootcamp.spring.blog.model.EntradaBlog;

public interface IEntradaBlogService extends IService<EntradaBlog>{
    Integer save(EntradaBlog obj);
}
