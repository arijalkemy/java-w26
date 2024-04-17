package bootcamp.bendezujonathan.covid.repository.interfaces;

import java.util.List;
import java.util.Random;

import bootcamp.bendezujonathan.covid.model.SeverityEnum;
import bootcamp.bendezujonathan.covid.model.Symptom;

public interface ISymptomRepository {

    static final List<Symptom> SYMPTOMS = List.of(new Symptom(1, "Perdida de sabor", SeverityEnum.BAJA),
            new Symptom(2, "Fiebre", SeverityEnum.MEDIA),
            new Symptom(3, "Respiracion pesada", SeverityEnum.ALTA));

    static final Random RANDOMIZER = new Random();

    static List<Symptom> findAll() {
        return SYMPTOMS;
    }

    static Symptom random() {
        return SYMPTOMS.get(RANDOMIZER.nextInt(3));
    }

}
