package bootcamp.bendezujonathan.link.repository.interfaces;

import java.util.List;
import java.util.Optional;

import bootcamp.bendezujonathan.link.model.Link;

public interface ILinkRepository {
    
    void save(Link toSave);
    void update(Link toUpdate);
    Optional<Link> findById(int id);
    List<Link> findAll();
    boolean exists(Link toCheck);
    int getNextId();
}
