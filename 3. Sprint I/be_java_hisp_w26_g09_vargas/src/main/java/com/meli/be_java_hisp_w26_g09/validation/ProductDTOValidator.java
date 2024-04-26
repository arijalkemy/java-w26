package com.meli.be_java_hisp_w26_g09.validation;

import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;
import java.util.stream.Stream;

@Component
public class ProductDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProductDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO dto = (ProductDTO) target;
        if (dto == null)
            errors.reject("Product can not be null.");

        Stream<?> streamValidator = Stream.of(dto.getProductId(), dto.getProductName(), dto.getBrand(), dto.getColor(), dto.getNotes(), dto.getType());
        if (streamValidator.anyMatch(Objects::isNull))
            errors.reject("Any field of Product can not be null.");
    }
}
