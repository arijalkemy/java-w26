package org.example.POO_P1_VIVO;

public class App {
    public static void main(String[] args) {
        Person person1 = null;
        Person person2 = null;
        Person person3 = null;
        Person person4 = null;
        Person person5 = null;
        Person person6 = null;

        try {
            person1 = new Person();
            person2 = new Person("Martin", 23, "123345");
            person4 = new Person("Agustina", 28, "123345", 100, 1.68);
            person5 = new Person("Camila", 15, "123345", 70, 1.75);
            person6 = new Person("Pedro", 45, "123345", 59, 1.72);

            person3 = new Person("Jose", 30, "123345", 70, 0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(person1);
            System.out.println(person2);
            System.out.println(person3);
            System.out.println(person4);
            System.out.println(person5);
            System.out.println(person6);

        }


    }
}
