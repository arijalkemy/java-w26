package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Vehicle car = new Car(20, 2, 12, "skx");
        Vehicle byke = new Motorcycle(30, 4, 34, "msn");
        Racing racing = new Racing(450, 3400, "Piston Coup", 10);

        racing.help(car);
        racing.help(byke);
        // another practice https://drive.google.com/file/d/1Iwz5uN8q3_FdMAQ-BCkFxUC3nNM0hKon/view
    }
}
