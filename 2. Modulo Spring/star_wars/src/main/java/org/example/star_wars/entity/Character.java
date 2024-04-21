package org.example.star_wars.entity;

public class CharacterEntity {
    private String name;
    private Integer height;
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterEntity() {
    }

    public CharacterEntity(String name, int height, int mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hairColor;
        this.skin_color = skinColor;
        this.eye_color = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hair_color;
    }

    public void setHairColor(String hairColor) {
        this.hair_color = hairColor;
    }

    public String getSkinColor() {
        return skin_color;
    }

    public void setSkinColor(String skinColor) {
        this.skin_color = skinColor;
    }

    public String getEyeColor() {
        return eye_color;
    }

    public void setEyeColor(String eyeColor) {
        this.eye_color = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
