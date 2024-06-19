package com.mercadolibre.fresh_market.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Being a class with static methods, a private constructor is created so that it cannot be instantiated
    private JsonUtil() {
    }

    /**
     * Method that reads a Json file and deserializes it to a POJO object type
     *
     * @param fileName  file name or route of file Json
     * @param valueType POJO Object type
     * @return Mapped POJO Object
     * @throws IOException generated exception by error in method
     */
    public static <T> T readJsonFromFile(String fileName, Class<T> valueType) throws IOException {
        String filePath = "src/test/resources/json/" + fileName;
        File file = new File(filePath);
        return objectMapper.readValue(file, valueType);
    }

    /**
     * Method that read a Json file and deserializes it to an object list
     *
     * @param fileName  file name or route of file Json
     * @param valueType POJO Object type
     * @return POJO Object list
     * @throws IOException generated exception by error in method
     */
    public static <T> List<T> readJsonFromFileToList(String fileName, Class<T> valueType) throws IOException {
        String filePath = "src/test/resources/json/" + fileName;
        return objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, valueType));
    }

}
