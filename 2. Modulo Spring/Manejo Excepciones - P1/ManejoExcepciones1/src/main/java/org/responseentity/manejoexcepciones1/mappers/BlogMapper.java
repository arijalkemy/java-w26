package org.responseentity.manejoexcepciones1.mappers;

import org.responseentity.manejoexcepciones1.dto.BlogDTO;
import org.responseentity.manejoexcepciones1.entity.BlogEntity;

public class BlogMapper {

    public static BlogEntity dtoToEntity(BlogDTO blogDTO){
        BlogEntity bE = new BlogEntity();
        bE.setAuthor(blogDTO.getAutor());
        bE.setTitle(blogDTO.getTitulo());

        return bE;
    }

    public static BlogDTO entityToDto(BlogEntity blog){
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setAutor(blog.getAuthor());
        blogDTO.setTitulo(blog.getTitle());
        blogDTO.setFechaPublicacion(blog.getPublishDate());

        return blogDTO;
    }
}
