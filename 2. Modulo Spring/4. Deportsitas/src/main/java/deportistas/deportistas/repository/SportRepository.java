package deportistas.deportistas.repository;

import deportistas.deportistas.Entity.Sport;
import lombok.Data;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
@Data
public class SportRepository {
    private static final List<Sport> sports = List.of(new Sport[]{
            new Sport(1,10, "Basketball"),
            new Sport(2,10, "Soccer"),
    });

    public static List<Sport> getSports() {
        return sports;
    }

    static public Optional<Sport> getSPortById(Integer id){
        return Optional.of(sports.stream().filter(sport -> sport.getId().equals(id)).findFirst().orElse(null));
    }
}
