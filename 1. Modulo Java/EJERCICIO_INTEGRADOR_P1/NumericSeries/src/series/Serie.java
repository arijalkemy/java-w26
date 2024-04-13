package series;

public abstract class Serie <T extends Number>  implements ISerie<T>{

    protected T valueSerie; // Represent value base with init the current serie
    protected T valueBase;  // Represent value base taken to reset serie
    
    protected T increment;  // Represent the increment of valueSerie
    /*
     * Should set value init for the serie 
     * @param valueInit
     *  
     */
    public Serie(T increment)
    {
        this.increment = increment;
    }

   public Serie(T valueSerie, T valueBase, T increment) {
        this.valueSerie = valueSerie;
        this.valueBase = valueBase;
        this.increment = increment;
    }

/**
    * Set value Base and 
    * @param valueInit represent the value init and base for the current serie
    */ 
    public void setValueInit(T valueInit){
        this.valueSerie = valueInit;
        this.valueBase = valueInit;
    }
    /**
     * @return Return value next T preview to call next
     */
    public abstract T next();

    /**
     * The value init of the current serie take the first value given when setValueInit is call
     */
    public void reset()
    {
        this.valueSerie = valueBase;
    }
    public T getValueSerie() {
        return valueSerie;
    }
    public void setValueSerie(T valueSerie) {
        this.valueSerie = valueSerie;
    }
    public T getValueBase() {
        return valueBase;
    }
    public void setValueBase(T valueBase) {
        this.valueBase = valueBase;
    }
    public T getIncrement() {
        return increment;
    }
    public void setIncrement(T increment) {
        this.increment = increment;
    }

}

