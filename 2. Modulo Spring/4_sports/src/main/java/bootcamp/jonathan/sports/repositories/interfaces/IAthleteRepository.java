package bootcamp.jonathan.sports.repositories.interfaces;

import java.util.List;

import bootcamp.jonathan.sports.model.Athlete;

public interface IAthleteRepository {

    static final List<Athlete> ATHLETES = List.of(new Athlete("Leo", "Bendezu", 23),
            new Athlete("Ignacio", "Cugura", 23));

    static List<Athlete> findAll() {
        return ATHLETES;
    }
}
