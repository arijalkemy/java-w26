package bootcamp.bendezujonathan.abstractas;

public class DoubleSerie extends Prototype<Double> {

    public DoubleSerie(Double initialValue, Double move) {
        super(initialValue, move);
    }

    @Override
    public Double seguiente() {
        this.validateStatus();
        this.actualValue += move;
        return this.actualValue;
    }
    
}
