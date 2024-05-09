package bootcamp.sprint.grupo02.sprintI.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("post_id")
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductResponseDTO product;
    private int category;
    private double price;
}
