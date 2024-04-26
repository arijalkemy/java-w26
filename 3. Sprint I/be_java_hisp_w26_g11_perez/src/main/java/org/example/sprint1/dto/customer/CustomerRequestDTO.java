package org.example.sprint1.dto.customer;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRequestDTO {
    @NotNull
    private List<Integer> categories;
}
