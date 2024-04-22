package meli.bootcamp.star_wars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDto {
  String msg;

  @JsonProperty("code_status")
  Integer codeStatus;
}
