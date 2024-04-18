package org.bootcamp.starwars.entity;

public class Character {

    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Character{");
        sb.append("name='").append(name).append('\'');
        sb.append(", height=").append(height);
        sb.append(", mass=").append(mass);
        sb.append(", hairColor='").append(hairColor).append('\'');
        sb.append(", skinColor='").append(skinColor).append('\'');
        sb.append(", eyeColor='").append(eyeColor).append('\'');
        sb.append(", birthYear='").append(birthYear).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", homeworld='").append(homeworld).append('\'');
        sb.append(", species='").append(species).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
