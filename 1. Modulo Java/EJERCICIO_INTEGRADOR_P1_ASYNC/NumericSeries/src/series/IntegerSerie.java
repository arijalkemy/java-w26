package series;

public class IntegerSerie extends Serie<Integer>
{

    public IntegerSerie(Integer increment) {
        super(increment);
        this.valueBase = Integer.valueOf(0);
        this.valueSerie = Integer.valueOf(0);
    }

    public IntegerSerie(Integer valueSerie, Integer valueBase, Integer increment)
    {
        super(valueSerie, valueBase, increment);
    }

    @Override
    public Integer next() {
        this.valueSerie += this.increment;
        return this.valueSerie; 
    }

}



