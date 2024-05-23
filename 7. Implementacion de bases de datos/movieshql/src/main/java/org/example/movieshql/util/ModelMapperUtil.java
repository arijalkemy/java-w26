package org.example.movieshql.util;

import org.example.movieshql.dto.ActorDTO;
import org.example.movieshql.model.Actor;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ModelMapperUtil {
    private static final ModelMapper mapper = new ModelMapper();

    public static <T, K> K entityToDTO(T entity, Class<K> dtoClass) {
        return mapper.map(entity, dtoClass);
    }

    public static <T, K> List<K> entitiesListToDTOs(List<T> entities, Class<K> dtoClass) {
        return entities.stream()
                .map(entity -> entityToDTO(entity, dtoClass))
                .toList();
    }

}
