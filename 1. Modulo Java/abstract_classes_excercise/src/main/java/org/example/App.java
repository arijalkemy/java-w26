package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calcs calcs = new Calcs();
        calcs.setInitialNumber(3);
        for (int i = 0; i < 4 ; i++) {
            System.out.println("series ("+i+") "+calcs.getNextSeriesValue());
        }
        calcs.restartSeries();
        System.out.println(calcs.getNextSeriesValue());
    }
}
