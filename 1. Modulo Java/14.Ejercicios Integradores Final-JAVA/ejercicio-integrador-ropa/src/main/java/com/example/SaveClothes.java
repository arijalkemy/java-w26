package com.example;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SaveClothes {

    private Map<Integer, List<PieceOfCloth>> clothes = new LinkedHashMap<>();
    private int counterId;

    public SaveClothes(){
        counterId = 1;
    }

    public SaveClothes(int counterId, Map<Integer, List<PieceOfCloth>> clothes){
        this.counterId = counterId;
        this.clothes = clothes;
    }



    public Integer saveClothes(List<PieceOfCloth> clothesList){
        int id = counterId++;
        // Posible trycatch aquí
        this.clothes.put(id, clothesList);
        System.out.println("Locker generado número {" + id + "}");
        return id;
    }

    public String getClothes(List<PieceOfCloth> clothesList){
        String result = "";
        for (PieceOfCloth pieceOfCloth : clothesList) {
            result = result + pieceOfCloth.toString();
        }
        return result;
    }

    public void showClothes(){

        for (Map.Entry<Integer, List<PieceOfCloth>> entry: this.clothes.entrySet()) {
            Integer id = entry.getKey();
            List<PieceOfCloth> list = entry.getValue();

            System.out.println(" Id de caja: " + id + "\n" +
                               " Prendas guardadas: " + getClothes(list));
        }
    }


    public List<PieceOfCloth> returnClothes(Integer num){
        return this.clothes.get(num);
    }


    

}
