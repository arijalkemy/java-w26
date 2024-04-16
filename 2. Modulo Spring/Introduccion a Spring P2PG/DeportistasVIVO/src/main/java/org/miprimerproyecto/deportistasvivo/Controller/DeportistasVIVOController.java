package org.miprimerproyecto.deportistasvivo.Controller;

import org.miprimerproyecto.deportistasvivo.BD.DeporteBD;
import org.miprimerproyecto.deportistasvivo.BD.PersonaBD;
import org.miprimerproyecto.deportistasvivo.DTO.DeporteDTO;
import org.miprimerproyecto.deportistasvivo.DTO.PersonaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasVIVOController {

@GetMapping(path = "/findSports")
@ResponseBody
public List<DeporteDTO> findSports(){
    DeporteBD deporteBD = new DeporteBD();
    return  deporteBD.getDeportes();
}

@GetMapping(path = "/findSport/{name}")
    @ResponseBody
    public DeporteDTO findSport(@PathVariable String name){
    DeporteBD deporteBD = new DeporteBD();
    return deporteBD.getDeporteByName(name);
}

@GetMapping(path = "/findSportsPersons")
    @ResponseBody
    public List<PersonaDTO> findSportsPersons(){
    PersonaBD personaBD = new PersonaBD();
    return personaBD.getPersonaList();
}

}
