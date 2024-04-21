package com.example.ejercicio_arquitectura_multicapa_p1_vivo.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

public class CustomIntegerDeserializer extends StdDeserializer<Integer> {

    public CustomIntegerDeserializer() {
        this(null);
    }

    public CustomIntegerDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Integer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String value = node.asText();
        if ("NA".equalsIgnoreCase(value)) {
            return null;
        }
        try {
            DecimalFormat format = new DecimalFormat("#,##0");
            return format.parse(value).intValue();
        } catch (ParseException e) {
            throw new IOException("Error parsing mass value", e);
        }
    }
}
