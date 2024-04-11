package org.example;

public class Category {
    private String name, description;
    private int id;
    private static int nextId = 0;
    public Category(String name, String description){
        this.name = name;
        this.description = description;
        this.id = nextId+=1;
    }
    public String getName(){
        return this.name.toLowerCase();
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
