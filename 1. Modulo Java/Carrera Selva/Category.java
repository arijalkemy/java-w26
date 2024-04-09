public class Category {
    private int id;
    private String name;
    private String description;
    private boolean acceptMinors;
    private int amountMinors;
    private int amountMayors;

    public Category(){
    }

    public Category(int id, String name, String description, boolean minAge, int amountMinors, int amountMayors) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.acceptMinors = minAge;
        this.amountMinors = amountMinors;
        this.amountMayors = amountMayors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getAccept(){
        return this.acceptMinors;
    }

    public int getAmountMayors() {
        return amountMayors;
    }

    public void setAmountMayors(int amountMayors) {
        this.amountMayors = amountMayors;
    }

    public int getAmountMinors() {
        return amountMinors;
    }

    public void setAmountMinors(int amountMinors) {
        this.amountMinors = amountMinors;
    }
}
