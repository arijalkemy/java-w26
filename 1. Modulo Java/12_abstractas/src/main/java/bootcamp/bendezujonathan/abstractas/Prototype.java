package bootcamp.bendezujonathan.abstractas;

import java.util.Objects;

public abstract class Prototype<T extends Number> {

    T initialValue;
    T actualValue;
    T move;

    Prototype(T initialValue, T move) {
        this.initialValue = initialValue;
        this.actualValue = initialValue;
        this.move = move;
    }

    public void reset() {
        this.actualValue = this.initialValue;
    }

    public void setInitial(T initial) {
        this.initialValue = initial;
    }

    protected void validateStatus(){
        if(Objects.isNull(actualValue)) {
            this.actualValue = initialValue;
        }
    }

    public abstract T seguiente();

}
