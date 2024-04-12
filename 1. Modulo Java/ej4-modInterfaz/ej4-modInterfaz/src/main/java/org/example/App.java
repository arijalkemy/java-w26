package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        String[][] data = {{"ford", "fiesta", "1000"},
                            {"ford", "Focus", "1200"},
                            {"ford", "Explorer", "2500"},
                            {"Fiat", "Uno", "500"},
                            {"Fiat", "Cronos", "1000"},
                            {"Fiat", "Torino", "1250"},
                            {"Chevrolet", "Aveo", "1250"},
                            {"Chevrolet", "Spin", "2500"},
                            {"Toyota", "Corola", "1200"},
                            {"Toyota", "Fortuner", "3000"},
                            {"Renault", "Logan", "950"},};


        Garage garage = new Garage(1);
        garage.populateData(data);


        garage.sortByPrice();
        garage.sortByName();
        garage.costQueryMax(1000);
        garage.costQueryMin(1000);
        garage.sumVehiclesCost();



    }






}