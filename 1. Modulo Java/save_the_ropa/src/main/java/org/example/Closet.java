package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Closet {
    private int counter;
    private Map<Integer, List<Clothing>> clothesMap;

    public Closet() {
        this.counter = 0;
        this.clothesMap = new HashMap<>();
    }

    public Integer storeClothes(List<Clothing> clothingList) {
        int nextVal = this.counter + 1;
        this.clothesMap.put(nextVal, clothingList);
        this.counter = nextVal;
        return nextVal;
    }

    public void showClothing() {
        this.clothesMap.forEach((key1, clothing) -> {
            int key = key1;
            System.out.println("Closet " + key);
            for (Clothing clothe : clothing) {
                System.out.println("\n" + clothe.getBrand() + " | " + clothe.getModel());
            }
        });
    }

    public List<Clothing> getClothing(Integer id) {
        return this.clothesMap.get(id);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Map<Integer, List<Clothing>> getClothesMap() {
        return clothesMap;
    }

    public void setClothesMap(Map<Integer, List<Clothing>> clothesMap) {
        this.clothesMap = clothesMap;
    }
}
