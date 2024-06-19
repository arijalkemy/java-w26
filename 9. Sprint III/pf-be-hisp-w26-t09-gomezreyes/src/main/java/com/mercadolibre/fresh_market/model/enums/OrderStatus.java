package com.mercadolibre.fresh_market.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mercadolibre.fresh_market.exceptions.StatusInvalidException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
@JsonDeserialize(using = OrderStatusDeserializer.class)
public enum OrderStatus {

    STATUS_CODE("Shopping cart"),
    SHOPPING_CART("SHOPPING_CART");

    private String statusCode;

    /**
     * This method is used to convert a string value into an OrderStatus enum.
     * It throws a StatusInvalidException if the provided value does not match any OrderStatus.
     *
     * @param value The string value to be converted into an OrderStatus.
     * @return The corresponding OrderStatus.
     * @throws StatusInvalidException if the value does not match any OrderStatus.
     */
    @JsonCreator
    public static OrderStatus forValue(String value) {
        return Arrays.stream(OrderStatus.values())
                .filter(status -> status.getStatusCode().equals(value))
                .findFirst()
                .orElseThrow(() -> new StatusInvalidException("Invalid order status: " + value));
    }

}
