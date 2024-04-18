package com.deportistas.deportistademo.entity;

public class Sport {
  private String name;
  private Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Sport(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public Sport() {
    }

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
