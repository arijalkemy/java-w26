package spring.blog.service.impl;

import org.springframework.stereotype.Service;
import spring.blog.dto.BlogDto;
import spring.blog.entity.EntradaBlog;
import spring.blog.exceptions.BadRequestException;
import spring.blog.repository.IBlogRepository;
import spring.blog.repository.impl.BlogRepositoryImpl;
import spring.blog.service.IBlogService;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    IBlogRepository blogRepository = new BlogRepositoryImpl();

    public int guardarEntrada(BlogDto entradaBlog) {
        EntradaBlog blog = new EntradaBlog(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getNombreAutor(), entradaBlog.getFecha());
        if (blogRepository.guardarEntradaBlog(blog)) {
            throw new BadRequestException("La entrada ya existe en el sistema");
        }
        return entradaBlog.getId();
    }

}
