package StarWars.Ejercicio.Controller;

import StarWars.Ejercicio.Entity.Personaje;
import StarWars.Ejercicio.Service.IStarWarsService;
import StarWars.Ejercicio.Service.Impl.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    private static IStarWarsService starWarsService;

    @GetMapping("/buscar-personajes")
    public List<Personaje> buscarPersonajes(@RequestParam String name){
        return StarWarsService.buscarPersonajesPorNombre(name);
    }


}
