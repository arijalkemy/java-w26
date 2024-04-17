package bootcamp.bendezujonathan.covid.repository.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.covid.model.Person;

public interface IPersonRepository {

    static List<Person> PEOPLE =  List.of(
        new Person(1, "John", "Doe", 25, List.of(ISymptomRepository.random(), ISymptomRepository.random())),
        new Person(2, "Jane", "Smith", 35, List.of(ISymptomRepository.random(), ISymptomRepository.random())),
        new Person(3, "Alice", "Johnson", 45, List.of(ISymptomRepository.random(), ISymptomRepository.random())),
        new Person(4, "Bob", "Williams", 55, List.of(ISymptomRepository.random(), ISymptomRepository.random())),
        new Person(5, "Charlie", "Brown", 65, List.of(ISymptomRepository.random(), ISymptomRepository.random())),
        new Person(6, "David", "Lee", 75, List.of(ISymptomRepository.random(), ISymptomRepository.random())),
        new Person(7, "Emily", "Taylor", 85, List.of(ISymptomRepository.random(), ISymptomRepository.random())),
        new Person(8, "Frank", "Clark", 90, List.of(ISymptomRepository.random(), ISymptomRepository.random())),
        new Person(9, "Grace", "Martinez", 19, List.of(ISymptomRepository.random(), ISymptomRepository.random())),
        new Person(10, "Hannah", "Garcia", 20, List.of(ISymptomRepository.random(), ISymptomRepository.random())));


    static List<Person> findAll() {
        return PEOPLE;
    }
}
