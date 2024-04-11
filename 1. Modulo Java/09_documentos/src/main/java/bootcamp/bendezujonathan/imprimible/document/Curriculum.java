package bootcamp.bendezujonathan.imprimible.document;

import java.util.List;

import bootcamp.bendezujonathan.person.Person;
import bootcamp.bendezujonathan.person.Skill;

import java.util.stream.Collectors;

public class Curriculum extends Document {

    private Person owner;
    private List<Skill> skills;

    public Curriculum(Person owner, List<Skill> skills, String path) {
        super(path);
        this.owner = owner;
        this.skills = skills;
    }

    @Override
    public void imprimir() {
        this.showType();
        System.out.printf(">> CV %s%s%n", owner.getNombre(), owner.getApellido());
        String skillsSpec = this.skillsToString();

        System.out.println("------ SKILLS TREE ------");
        System.out.println(skillsSpec);
    }

    private String skillsToString() {
        return this.skills.stream()
                .map(Skill::toString)
                .collect(Collectors.joining("\n"));
    }

}
