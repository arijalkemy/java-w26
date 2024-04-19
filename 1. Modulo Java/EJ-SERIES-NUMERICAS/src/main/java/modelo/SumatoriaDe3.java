package modelo;

public class SumatoriaDe3 extends Serie<Integer>{
    public SumatoriaDe3(Integer valorInicial) {
        super(valorInicial);
    }

    public Integer ejecutar() {
        return this.getValorActual() + 3;
    }

}
