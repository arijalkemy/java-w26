package App.Services;

import App.tdo.CharacterTDO;

import java.util.List;

public interface IStarwars {
    List<CharacterTDO> getCharacterByName(String name);
}
