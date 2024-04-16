package co.com.mercadolibre.deportistas.repository.impl;

import co.com.mercadolibre.deportistas.entity.Deporte;
import co.com.mercadolibre.deportistas.entity.Persona;
import co.com.mercadolibre.deportistas.entity.dto.PersonaDeporteDto;
import co.com.mercadolibre.deportistas.repository.IDeporteRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository implements IDeporteRepository {

    @Override
    public List<Deporte> buscarTodos() {
        return this.devolverLista();
    }

    @Override
    public String existeDeporte(String nombre) {
        List<Deporte> consulta = this.devolverLista();
        Deporte deporteEncontrado = consulta.stream().filter(deporte -> deporte.getNombre().equals(nombre))
                .findFirst().orElse(null);
        return deporteEncontrado != null ? deporteEncontrado.getNivel() : "No se encuentra el deporte registrado";
    }

    private List<Deporte> devolverLista() {
        Deporte futbol = new Deporte("Fútbol", "Avanzado");
        Deporte tenis = new Deporte("Tenis", "Intermedio");
        Deporte natacion = new Deporte("Natación", "Principiante");

        List<Deporte> listaDeportes = new ArrayList<>();
        listaDeportes.add(futbol);
        listaDeportes.add(tenis);
        listaDeportes.add(natacion);
        return listaDeportes;
    }

    @Override
    public List<PersonaDeporteDto> listarPersonasDeportistas() {
        List<PersonaDeporteDto> personasDeportes = new ArrayList<>();
        List<Persona> personas = new ArrayList<>();
        List<Deporte> deportes = this.buscarTodos();

        for (int i = 0; i < 10; i++) {
            Faker faker = new Faker();
            Persona persona = new Persona(faker.name().firstName(), faker.name().lastName(),
                    faker.number().randomDigit(), null);
            personas.add(persona);
            for (Deporte deporte : deportes) {
                persona.setDeporte(deporte);
                PersonaDeporteDto personaDeporte = new PersonaDeporteDto(persona.getNombre(), persona.getApellido(),
                        deporte.getNombre());
                personasDeportes.add(personaDeporte);
            }
        }
        return personasDeportes;
    }

}
