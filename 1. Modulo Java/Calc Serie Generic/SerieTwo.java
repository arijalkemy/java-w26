public class SerieTwo extends Serie<Integer> {
    public SerieTwo(Integer initial) {
        super(2, initial);
    }

    @Override
    public void next() {
        super.nextIndex();
        int current = (super.getIndex()) * super.getNumber() + (super.getInitial());
        System.out.println("index: " + (super.getIndex() - 1) + " - " + current);
    }
}
