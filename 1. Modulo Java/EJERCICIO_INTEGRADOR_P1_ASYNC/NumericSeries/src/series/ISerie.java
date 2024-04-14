package series;

public interface ISerie <T extends Number> {

    public abstract void setValueInit(T valueInit);
    public abstract T next();
    public abstract void reset();
}
