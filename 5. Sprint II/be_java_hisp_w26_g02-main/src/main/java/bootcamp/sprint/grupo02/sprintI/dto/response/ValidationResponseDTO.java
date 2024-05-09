package bootcamp.sprint.grupo02.sprintI.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationResponseDTO {
    
    private String field;

    @JsonProperty("rejected_value")
    private Object rejectedValue;
    private String message;




}
