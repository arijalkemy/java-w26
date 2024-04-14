public class Perecederos extends Productos {


    //Atributos
    private int diasPorCaducar;
    //Constructor
    public Perecederos(String nombre, double precio,int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }
    //Metodos

    @Override
    public double calcular(int cantidad) {
       double precioOriginal= super.calcular(cantidad);
       switch (diasPorCaducar){
           case 1:
               return precioOriginal/4;
           case 2:
               return precioOriginal/3;

           case 3:
               return precioOriginal/2;
           default:
               return  precioOriginal;

       }
    }

    //Gettes y Setters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;


    }
}
