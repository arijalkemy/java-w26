package org.example.sprint1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.sprint1.dto.PostDTO;
import org.example.sprint1.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mapper {
    ObjectMapper mapper = new ObjectMapper();

    public Mapper() {
        mapper.registerModule(new JavaTimeModule());
    }


    public List<PostDTO> mappingPostToPostDto(Map<Integer, List<Post>> posts) {
        List<PostDTO> listPostDto = new ArrayList<>();

        for (Map.Entry<Integer, List<Post>> entry : posts.entrySet()) {
            // Mapea Post -> PostDTO y se agrega a una list de PostDTO
            listPostDto.addAll(
                    entry.getValue().stream()
                            .map(v -> {
                                PostDTO postDTO = mapper.convertValue(v, PostDTO.class);
                                postDTO.setSellerId(entry.getKey());
                                return postDTO;
                            })
                            .toList()
            );
        }

        return listPostDto;
    }
}
