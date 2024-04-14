public class NoPerishable extends Product {
    private String type;

    public NoPerishable(String name, double price) {
        super(name, price);
        this.type = type;
    }

    @Override
    public double calculate(int numberOfProducts) {
        return super.calculate(numberOfProducts);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NoPerishable{" +
                "type='" + type + '\'' +
                '}';
    }
}
