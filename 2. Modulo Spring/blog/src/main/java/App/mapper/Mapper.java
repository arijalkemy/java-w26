package App.mapper;

import App.dto.BlogDto;
import App.entity.BlogEntity;

public class Mapper {
    public static BlogDto entityToDto (BlogEntity entity){
        return new BlogDto(entity.getId(), entity.getTituloDelBlog(), entity.getNombreDelAutor(), entity.getDateTime());
    }

    public static BlogEntity dtoToEntity(BlogDto dto){
        return new BlogEntity(dto.getId(), dto.getTituloDelBlog(),dto.getNombreDelAutor(), dto.getDateTime());
    }
}
