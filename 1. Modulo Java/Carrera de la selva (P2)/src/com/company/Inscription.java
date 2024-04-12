package com.company;

import com.company.enums.Category;

import java.util.ArrayList;
import java.util.List;

public class Inscription {
    private static int nextId = 1;
    private int id;
    private Category category;
    private List<Person> personList;
    private List<Integer> amountPerPerson;
    private int totalAmount;


    public Inscription(Category category) {
        this.category = category;
        this.id = nextId;
        this.personList = new ArrayList<>();
        this.amountPerPerson = new ArrayList<>();
        this.totalAmount = 0;
        nextId++;
    }
    public void subscribePerson(Person person){
        int amount = calculateAmount(person);
        totalAmount = totalAmount + amount;
        personList.add(person);
        amountPerPerson.add(amount);
    }

    private int calculateAmount(Person person){
        switch (category){
            case SMALL: if(person.getAge() < 18){
                return 1300;
            }else{
                return 1500;
            }
            case MIDDLE: if(person.getAge() < 18){
                return 2000;
            }else{
                return 2300;
            }
            case ADVANCE: if(person.getAge() < 18){
                return 0;
            }else{
                return 2800;
            }
        }
        return 0;
    }



    public void showInfo(){
        System.out.println("Category: " + category);
        System.out.println("---------------------");
        System.out.println("LIST");
        for(Person person : personList){
            System.out.println("Name: " + person.getName()+ " ID: " + person.getId() + " Age: "+ person.getAge() + " DNI: " + person.getDni());
        }
        System.out.println("---------------------");
        System.out.println("AMOUNT PER PERSON ");
        for(int amount : amountPerPerson){
            System.out.println(amount);
        }
        System.out.println("---------------------");
        System.out.println("TOTAL AMOUNT OF THIS CATEGORY: " + totalAmount);
    }
    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", category=" + category +
                '}';
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
