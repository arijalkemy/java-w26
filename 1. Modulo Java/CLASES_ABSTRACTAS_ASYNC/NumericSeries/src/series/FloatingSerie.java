package series;

public class FloatingSerie extends Serie<Float>
{

    public FloatingSerie(Float increment) {
        super(increment);
    }

    public FloatingSerie(Float valueSerie, Float valueBase, Float increment) {
        super(valueSerie, valueBase, increment);
    }

    @Override
    public Float next() {
        this.valueSerie += this.increment;
        return this.valueSerie;
    }
}
