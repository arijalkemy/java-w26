package series;

public interface IExecutor<T extends Number> {
    static public void execSerie(Serie serie, int limit)
    {
        for (int i = 0; i < limit; i++) {
            System.out.println(serie.next());
        }
    }
}
