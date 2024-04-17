package meli.bootcamp.deportistas.repository;

import meli.bootcamp.deportistas.entities.Sport;

import java.util.List;

public class SportRepository {
    public static final List<Sport> SPORTS = List.of(new Sport("Tenis", "2"), new Sport("Rugby", "4"), new Sport(
            "Basket", "3"));
}
