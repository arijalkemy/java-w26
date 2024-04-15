public abstract class  Serie<T extends Number> {
    private Integer number;
    private Integer index;
    private T initial;

    public Serie(Integer number, T initial) {
        this.number = number;
        this.initial = initial;
        this.index = 1;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void nextIndex(){
        this.index++;
    }

    public Integer getIndex(){
        return this.index;
    }

    public T getInitial() {
        return this.initial;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setInitial(T initial) {
        this.initial = initial;
    }

    public void resetSerie() {
        this.index = 1;
    }

    public abstract void next();
}
