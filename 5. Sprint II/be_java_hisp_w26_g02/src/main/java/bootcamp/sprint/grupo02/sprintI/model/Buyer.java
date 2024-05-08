package bootcamp.sprint.grupo02.sprintI.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Buyer {

    private int id;
    private String name;
    private List<Seller> follows;

    public Buyer() {
        this.follows = new ArrayList<>();
    }

}
