import series.FloatingSerie;
import series.IExecutor;
import series.IntegerSerie;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("-------------------------");
        System.out.println("Type: Integer");

        IntegerSerie integerSerie = new IntegerSerie(Integer.valueOf(2));
        IExecutor.execSerie(integerSerie, 10);

        System.out.println("-------------------------");
        System.out.println("Type: Float");
        FloatingSerie floatingSerie = new FloatingSerie(Float.valueOf(0.5f));
        floatingSerie.setValueInit(Float.valueOf(0));
        
        IExecutor.execSerie(floatingSerie, 5);


        System.out.println("-------------------------");
        System.out.println("Scene: 1");
        System.out.println("Type: Integer");

        IntegerSerie integerSerie1 = new IntegerSerie(Integer.valueOf(2)); 
        IExecutor.execSerie(integerSerie1, 4);

        System.out.println("-------------------------");
        System.out.println("Scene: 2");
        System.out.println("Type: Integer");
        
        integerSerie1.setValueInit(1);
        IExecutor.execSerie(integerSerie1, 4);

        System.out.println("-------------------------");
        System.out.println("Scene: 3");
        System.out.println("Type: Integer");

        IntegerSerie integerSerie2 = new IntegerSerie(Integer.valueOf(3)); 
        IExecutor.execSerie(integerSerie2, 4);
    }
}
