package com.meli.be_java_hisp_w26_g09.validation;

import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;
import java.util.stream.Stream;

@Component
public class PostPromoValidator implements Validator {
    final ProductDTOValidator productDTOValidator;

    public PostPromoValidator(ProductDTOValidator productDTOValidator) {
        this.productDTOValidator = productDTOValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PostDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        PostDTO dto = (PostDTO) target;
        if (dto == null)
            errors.reject("Post for promo is empty, check values please.");

        Stream<?> streamValues = Stream.of(dto.getUserId(), dto.getDate(), dto.getCategory(), dto.getPrice(), dto.getHasPromo(), dto.getDiscount());

        productDTOValidator.validate(dto.getProduct(), errors);


        if (streamValues.anyMatch(Objects::isNull)) {
            errors.reject("Any field can not be null");
        } else {
            if (dto.getHasPromo().equals(false))
                errors.rejectValue("hasPromo", "should be true");

            if (dto.getPrice() < 0)
                errors.rejectValue("price", "The price cannot be negative");
        }
    }
}
