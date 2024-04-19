package org.responseentity.agenciaautos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceEntity {
    private String date;
    private String kilometers;
    private String descriptions;
}