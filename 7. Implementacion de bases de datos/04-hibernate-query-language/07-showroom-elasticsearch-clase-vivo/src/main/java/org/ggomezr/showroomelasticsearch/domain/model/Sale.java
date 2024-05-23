package org.ggomezr.showroomelasticsearch.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "sales")
public class Sale {
    @Id
    private String code;

    @Field(type = FieldType.Date, format = DateFormat.basic_date)
    private LocalDate date;
    private Double total;
    private String paymentMethod;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Clothing> clothingList;
}
