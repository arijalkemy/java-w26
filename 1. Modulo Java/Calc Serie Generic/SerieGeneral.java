public class SerieGeneral extends Serie<Long>{
    public SerieGeneral(Integer number, Long initial) {
        super(number, initial);
    }

    @Override
    public void next() {
        super.nextIndex();
        long current = (long) (super.getIndex()) * super.getNumber() + (super.getInitial());
        System.out.println("index: " + (super.getIndex() - 1) + " - " + current);
    }
}
