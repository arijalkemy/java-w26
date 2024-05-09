package bootcamp.sprint.grupo02.sprintI.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
/**
* Use for errors, exceptions and success messages
* */
public class MessageResponseDTO {
    private String message;
}
