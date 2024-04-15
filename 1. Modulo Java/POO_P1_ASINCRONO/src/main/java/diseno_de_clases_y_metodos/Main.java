package diseno_de_clases_y_metodos;

public class Main {
    public static void main(String[] args) {
        Automovil auto = new Automovil("Ferrari","Azul",2000);
        System.out.println(auto.mostrarMarcaYColor());
        auto.setMarca("BMW");
        auto.setColor("Negro");
        auto.setKilometros(200);
        System.out.println(auto.mostrarMarcaYColor());
    }
}
