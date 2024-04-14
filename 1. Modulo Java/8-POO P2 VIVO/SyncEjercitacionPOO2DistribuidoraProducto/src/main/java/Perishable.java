public class Perishable extends Product {
    private int daysToExpire;

    public double calculate(int numberOfProducts) {
        double precioFinal = getPrice();
        // Reducir el precio final según los días por caducar
        if (daysToExpire == 1) {
            precioFinal += precioFinal * 4; // Reducción 4 veces el precio final
        } else if (daysToExpire == 2) {
            precioFinal += precioFinal * 3; // Reducción 3 veces el precio final
        } else if (daysToExpire == 3) {
            precioFinal /= 2; // Reducción a la mitad del precio final
        }

        return precioFinal * numberOfProducts;
    }

    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysToExpire=" + daysToExpire +
                '}';
    }
}
