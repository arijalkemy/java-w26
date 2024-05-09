package bootcamp.sprint.grupo02.sprintI.model;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seller {

    private int id;
    private String name;

    @EqualsAndHashCode.Exclude
    private List<Buyer> followers;

}
