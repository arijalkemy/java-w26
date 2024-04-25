package bootcamp.sprint.grupo02.sprintI.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    private int id;
    private String name;
    private List<Buyer> followers;

    public Seller(int id, String name) {
        this.id = id;
        this.name = name;
        this.followers = new ArrayList<Buyer>();
    }
}
