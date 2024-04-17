package org.example.multi_layer_p1_starwars.dto;

import org.example.multi_layer_p1_starwars.entity.Character;
import java.util.List;

public class JsonDataDTO {
    private List<Character> results;

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}
