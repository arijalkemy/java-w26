package org.example.social_meli.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Mapper {
    private ObjectMapper mapper;

    public Mapper() {
        this.mapper= new ObjectMapper();
    }

}
