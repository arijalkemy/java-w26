package deportistas.deportistas.Service;

import deportistas.deportistas.DTO.PersonDTO;
import deportistas.deportistas.Entity.Person;
import deportistas.deportistas.Entity.Sport;
import deportistas.deportistas.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IpersonService {


    public List<PersonDTO> getSportsPersons(){
        return PersonaRepository.getSportsPerson();
    }


}
