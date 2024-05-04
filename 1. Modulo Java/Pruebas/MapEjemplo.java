import java.util.HashMap;
import java.util.Map;

public class MapEjemplo {
    Map<Integer,String> mapa = new HashMap<Integer,String>();

    public void Ejemplo()
    {
        mapa.put(1,"Juan");
        mapa.put(2,"Pedro");

        mapa.size();

        for(Map.Entry<Integer,String> entry : mapa.entrySet())
        {
            System.out.println(entry.getKey() + "<- clave |  valor -> " + entry.getValue());
        }
        mapa.remove(1);
    }
}
