package com.group03.sprint1.dto.response;

import com.group03.sprint1.dto.PublicationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationListDTO implements Serializable {
    private List<PublicationDTO> publications;
}
