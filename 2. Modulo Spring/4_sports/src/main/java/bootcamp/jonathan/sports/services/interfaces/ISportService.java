package bootcamp.jonathan.sports.services.interfaces;

import java.util.List;

import bootcamp.jonathan.sports.model.Sport;

public interface ISportService {
    List<Sport> findSports();
    Sport findByName(String name);
    Sport random();
}
