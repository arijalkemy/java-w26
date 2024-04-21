package deportistas.deportistas.Service;

import deportistas.deportistas.Entity.Sport;

import java.util.List;
import java.util.Optional;

public interface IsportService {
    public List<Sport> getAllSports();
    public Optional<Sport> getSportByName(String name);
}
