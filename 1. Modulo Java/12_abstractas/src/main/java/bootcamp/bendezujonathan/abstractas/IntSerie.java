package bootcamp.bendezujonathan.abstractas;


public class IntSerie extends Prototype<Integer> {

    public IntSerie(Integer initialValue, Integer move) {
        super(initialValue, move);
    }

    

    @Override
    public Integer seguiente() {
        this.validateStatus();
        this.actualValue += move;
        return this.actualValue;
    }



}
