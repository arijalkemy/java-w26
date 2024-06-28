import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepositorio {

   private static List<Localizador> listaLocalizadores = new ArrayList<>();

   public static void adicionarLocalizador(Localizador localizador){
       listaLocalizadores.add(localizador);
       System.out.println("Localizador Guardado: " + localizador);
   }

   public static boolean aplicaDescuento(Cliente cliente){
       return listaLocalizadores.stream().filter(c -> c.getCliente().equals(cliente)).count()>=2;
   }

}
