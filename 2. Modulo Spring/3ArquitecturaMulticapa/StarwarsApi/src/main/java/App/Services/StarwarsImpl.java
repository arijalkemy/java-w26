package App.Services;

import App.repository.RepositoryWars;
import App.tdo.CharacterTDO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Service
public class StarwarsImpl implements IStarwars {
    RepositoryWars repo;

    StarwarsImpl(){
        repo = new RepositoryWars();
        repo.populate();

    }
    @Override
    @ResponseBody
    public List<CharacterTDO> getCharacterByName(String name) {
        return repo.characterList.stream().filter(character -> character.getNombre().contains(name)).toList();
    }
}
