package Clases;

public class DescuentoTotal extends Descuento{


    public DescuentoTotal(double descuento) {
        super(descuento);
    }

    public double aplicarDescuento(Localizador localizador){
        return localizador.getTotal() - localizador.getTotal()*this.getDescuento();
    }
}
