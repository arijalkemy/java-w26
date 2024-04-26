package com.group03.sprint1.dto.response;

import com.group03.sprint1.dto.PublicationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseIdPublicationsDTO {

    private Integer userId;
    private List<PublicationDTO> publications;
}
