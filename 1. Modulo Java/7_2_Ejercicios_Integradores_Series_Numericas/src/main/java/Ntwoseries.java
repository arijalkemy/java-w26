public class Ntwoseries extends Prototipo{
    private int value ;

    @Override
    public int nextNumber() {
        setValue(getValue() + 2);
        return getValue();
    }

    @Override
    public void restartSeries() {
        setValue(2);
    }

    @Override
    public void initialValue(int i) {
       setValue(i);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
