import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda celular = new Prenda("Motorola", "31231234");
        Prenda ps4 = new Prenda("PS4", "00000F23213");
        
        Integer id_ropero = guardaRopa.guardarRopa(List.of(celular, ps4));
        System.out.println("Ropero id: " + id_ropero);
        guardaRopa.mostrarPrendas();

        List<Prenda> prendas_guardadas = guardaRopa.devolverRopa(id_ropero);
        System.out.println("Prendas devueltas: " + prendas_guardadas);
        
        guardaRopa.mostrarPrendas();
        guardaRopa.mostrarPrendas();
    }
}
