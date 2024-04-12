package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Clothing cloth1 = new Clothing("Sei", "sol");
        Clothing cloth2 = new Clothing("Sam", "Mos");
        List<Clothing> clothingList = new ArrayList<>(Arrays.asList(
                cloth1, cloth2
        ));
        Closet closet = new Closet();
        int closetId = closet.storeClothes(clothingList);
        System.out.println("Closet id:"+closetId);
        List<Clothing> foundList = closet.getClothing(closetId);
        System.out.println("Clothing: "+foundList);
    }
}
