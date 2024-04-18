package ejercicioDeportista.ejercicioDeportista.controlador;

import ejercicioDeportista.ejercicioDeportista.entidades.PersonaDTO;
import ejercicioDeportista.ejercicioDeportista.servicio.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSportsPersons")
public class PersonaController {

    @Autowired
    IPersonaService personaService;
    @GetMapping
    public ResponseEntity<List<PersonaDTO>> getPersonaDeportista(){
        return ResponseEntity.ok(this.personaService.obtenerPersonasDeportistas());
    }
}
