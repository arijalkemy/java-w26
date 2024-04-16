package App.controller;

import App.Services.StarwarsImpl;
import App.tdo.CharacterTDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    StarwarsImpl starwars;

    @GetMapping("/{name}/")
    List<CharacterTDO> starWarsQuery(@PathVariable String name){
        System.out.println("llego");
        return starwars.getCharacterByName(name);
    }

    @GetMapping("ping/")
    String pong(){
        return "pong";
    }
}
