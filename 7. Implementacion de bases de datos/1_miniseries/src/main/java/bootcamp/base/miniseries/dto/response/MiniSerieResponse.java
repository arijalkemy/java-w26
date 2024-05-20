package bootcamp.base.miniseries.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MiniSerieResponse {

    private Long id;

    private String name;

    private Double rating;
    @JsonProperty("amount-of-awards")
    private int amountOfAwards;

}
