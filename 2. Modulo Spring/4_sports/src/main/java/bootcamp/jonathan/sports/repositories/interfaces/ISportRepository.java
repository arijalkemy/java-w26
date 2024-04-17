package bootcamp.jonathan.sports.repositories.interfaces;

import java.util.List;

import bootcamp.jonathan.sports.model.Sport;
import bootcamp.jonathan.sports.model.SportEnum;

public interface ISportRepository {

    static final List<Sport> SPORTS = List.of(new Sport("Futbol", SportEnum.INTERMEDIO),
    new Sport("Basquet", SportEnum.AVANZADO));

    static List<Sport> findAll() {
        return SPORTS;
    }
}
