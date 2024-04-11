public class Inscription {
    private int id;
    private Category category;
    private Participante participante;
    private int amount;

    public Inscription() {
    }

    public Inscription(int id, Category category, Participante participante) {
        this.id = id;
        this.category = category;
        this.participante = participante;
        this.amount = (participante.getAge() >= 18 ? category.getAmountMayors() : category.getAmountMinors());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
