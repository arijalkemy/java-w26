package meli.bootcamp.hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonPropertyOrder({"patente_modelo_marca", "total"})
public class PatenteModeloMarcaTotalDto {
    @JsonProperty("patente_modelo_marca")
    List<PatenteModeloMarcaDto> patenteModeloMarcaDto;
    Double total;
}
