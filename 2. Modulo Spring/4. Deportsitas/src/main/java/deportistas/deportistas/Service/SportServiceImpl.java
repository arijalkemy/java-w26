package deportistas.deportistas.Service;

import deportistas.deportistas.Entity.Sport;
import deportistas.deportistas.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportServiceImpl implements IsportService {


    @Override
    public List<Sport> getAllSports() {
        return SportRepository.getSports();
    }

    @Override
    public Optional<Sport> getSportByName(String name) {
        return SportRepository.getSports().stream().filter(sport -> sport.getNombre().equalsIgnoreCase(name))
                .findFirst();

    }
}
