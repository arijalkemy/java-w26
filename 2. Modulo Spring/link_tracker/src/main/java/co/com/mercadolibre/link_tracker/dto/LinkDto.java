package co.com.mercadolibre.link_tracker.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
public class LinkDto {

    private Integer id;
    private String originalUrl;
    private Integer redirectCount;
    private String password;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime time = LocalDateTime.now();
    private Boolean valid;

    public LinkDto(Integer id, String originalUrl, String password, LocalDateTime time) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.password = password;
        this.time = time;
        this.valid = true;
        this.redirectCount = 0;
    }

    public void sumCount(){
        this.redirectCount ++;
    }
}
