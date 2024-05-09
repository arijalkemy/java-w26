package bootcamp.sprint.grupo02.sprintI.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class FileDataBaseUtil <M> {
    
    @Value("${app.scope}")
    private String scope;

    private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();

    public List<M> readFromJsonFile(String fileName, Class<M> clazz) {
        List<M> loadedData = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile(buildPath(fileName));
            loadedData = MAPPER.readValue(file, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
        return loadedData;
    }

    public void saveData(List<M> toSave, String fileName) {
        try {
            File file = ResourceUtils.getFile(buildPath(fileName));
            MAPPER.writeValue(file, toSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }


    private String buildPath(String name) {
        return String.format("./src/%s/resources/json/%s", scope, name);
    }
}
