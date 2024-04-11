import java.util.List;

public class Curriculum implements Printer {
    String name;
    int age;
    List<String> skills;

    public Curriculum(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    @Override
    public void print() {
        System.out.println("Nombre: " + name);
        System.out.println("Edad: " + age);
        System.out.println("Habilidades: " + skills);
    }
}
