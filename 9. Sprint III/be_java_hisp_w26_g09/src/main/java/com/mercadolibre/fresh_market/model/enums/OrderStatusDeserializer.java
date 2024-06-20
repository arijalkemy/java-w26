package com.mercadolibre.fresh_market.model.enums;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mercadolibre.fresh_market.exceptions.StatusInvalidException;

import java.io.IOException;



public class OrderStatusDeserializer extends JsonDeserializer<OrderStatus> {

    /**
     * This method is used to convert a string value into an OrderStatus enum.
     * It throws a StatusInvalidException if the provided value does not match any OrderStatus.
     *
     * @param p     The JsonParser object that provides access to the JSON data being deserialized.
     * @param ctxt  The DeserializationContext object that contains contextual information for deserialization.
     * @return The corresponding OrderStatus enum value based on the provided string.
     * @throws IOException if there is an error reading the JSON data.
     * @throws JsonParseException if the provided value does not match any valid OrderStatus.
     */
    @Override
    public OrderStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        try {
            return OrderStatus.forValue(value);
        } catch (StatusInvalidException e) {
            throw new JsonParseException(p, e.getMessage(), e);
        }
    }
}
