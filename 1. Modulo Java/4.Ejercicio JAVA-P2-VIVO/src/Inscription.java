public class Inscription {
    private String id;
    private Category category;
    private double amount;

    public Inscription() {

    }

    public Inscription(String id, Category category, double amount) {
        this.id = id;
        this.category = category;
        this.amount = amount;
    }

    public double calculateAmount(int age, String categoryId) {
        double result;
    
        switch (categoryId) {
            case "1":
                result = (age < 18) ? 1300 : 1500;
                break;
            case "2":
                result = (age < 18) ? 2000 : 2300;
                break;
            case "3":
                if (age >= 18) {
                    result = 2800;
                } else {
                    throw new IllegalArgumentException("Edad no permitida para la categoría 3");
                }
                break;
            default:
                throw new IllegalArgumentException("Categoría inexistente: " + categoryId);
        }
    
        return result;
    }
    

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
