package modelo;

public class SumatoriaDe2 extends Serie<Integer>{

    public SumatoriaDe2(Integer valorInicial) {
        super(valorInicial);
    }

    public Integer ejecutar() {
        return this.getValorActual() + 2;
    }

}
