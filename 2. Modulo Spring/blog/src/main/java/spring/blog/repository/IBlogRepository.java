package spring.blog.repository;

import spring.blog.dto.BlogDto;
import spring.blog.entity.EntradaBlog;

public interface IBlogRepository {
     boolean guardarEntradaBlog(EntradaBlog entradaBlog);

}
