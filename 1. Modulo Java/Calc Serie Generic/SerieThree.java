public class SerieThree extends Serie<Double> {
    public SerieThree(Double initial) {
        super(3, initial);
    }

    public void next() {
        super.nextIndex();
        double current = (super.getIndex()) * super.getNumber() + (super.getInitial());
        System.out.println("index: " + (super.getIndex() - 1) + " - " + current);
    }
}
