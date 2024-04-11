package bootcamp.bendezujonathan.person;

public class Skill {
    
    private SkillType type;
    private String description;

    public Skill(SkillType type, String description) {
        this.type = type;
        this.description = description;
    }

    public SkillType getType() {
        return this.type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return String.format("* Tipo de Skill: %s%n  Descripcion: %s", this.type.name(), this.description);
    }

}
