package com.company;

import com.company.enums.Category;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person(43238888, "Carlitos", "Moccia",44,44444444,911,"O+");
        Person person2 = new Person(14138888, "Dylan", "Moa",17,44444444,911,"O+");
        Person person3 = new Person(14138889, "Ella", "Doe", 25, 55555555, 922, "A-");
        Person person4 = new Person(14138890, "John", "Smith", 30, 66666666, 933, "B+");
        Person person5 = new Person(14138891, "Emma", "Johnson", 11, 77777777, 944, "AB-");
        Person person6 = new Person(14138892, "Michael", "Brown", 35, 88888888, 955, "A+");

        Inscription inscription1 = new Inscription(Category.SMALL);
        Inscription inscription2 = new Inscription(Category.MIDDLE);
        Inscription inscription3 = new Inscription(Category.ADVANCE);

        inscription1.subscribePerson(person1);
        inscription1.subscribePerson(person2);

        inscription2.subscribePerson(person3);
        inscription2.subscribePerson(person4);

        inscription3.subscribePerson(person5);
        inscription3.subscribePerson(person6);


        inscription1.showInfo();
        System.out.println("///////////////////////////////////////");
        inscription2.showInfo();
        System.out.println("///////////////////////////////////////");
        inscription3.showInfo();
        System.out.println("///////////////////////////////////////");

        System.out.println("TOTAL AMOUNT EARNED FOR THIS RACE: " + (inscription1.getTotalAmount() + inscription2.getTotalAmount() + inscription3.getTotalAmount()));
    }
}
