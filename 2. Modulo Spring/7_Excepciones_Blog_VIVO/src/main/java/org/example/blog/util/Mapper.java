package org.example.blog.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.blog.dto.EntradaBlogDto;
import org.example.blog.entity.EntradaBlog;

public class Mapper {

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper().findAndRegisterModules();
    }

    public static EntradaBlog mapearAEntidad(EntradaBlogDto dto) {
        return getObjectMapper().convertValue(dto, EntradaBlog.class);
    }

    public static EntradaBlogDto mapearADto(EntradaBlog entidad) {
        return getObjectMapper().convertValue(entidad, EntradaBlogDto.class);
    }
}
