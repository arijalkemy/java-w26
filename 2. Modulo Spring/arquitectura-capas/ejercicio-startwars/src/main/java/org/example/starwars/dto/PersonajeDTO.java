package org.example.starwars.dto;


public record PersonajeDTO(
    String name,
    Integer height,
    Integer mass,
    String gender,
    String homeworld,
    String species
) {}
