package org.example.ejerciciocalculadoracalorias.repository;

import org.example.ejerciciocalculadoracalorias.entity.Dish;
import org.example.ejerciciocalculadoracalorias.entity.Ingredients;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository implements IMenuRepository{


    private IngredientsRepository ingredientsRepository;
    private List<Dish> dishList = new ArrayList<>();

    public MenuRepository(){
        ingredientsRepository = new IngredientsRepository();
        List<Ingredients> listIngredients = new ArrayList<>();
        listIngredients.add(ingredientsRepository.findOne("Atún en lata con agua"));
        listIngredients.add(ingredientsRepository.findOne("Tomates"));
        listIngredients.add(ingredientsRepository.findOne("Lechuga"));
        listIngredients.add(ingredientsRepository.findOne("Cebolla"));
        dishList.add(new Dish("ensalada de atun",250, listIngredients));

        listIngredients = new ArrayList<>();
        listIngredients.add(ingredientsRepository.findOne("Pollo"));
        listIngredients.add(ingredientsRepository.findOne("Papas cocidas"));
        dishList.add(new Dish("pollo con papas",150, listIngredients));

        listIngredients = new ArrayList<>();
        listIngredients.add(ingredientsRepository.findOne("Mango"));
        listIngredients.add(ingredientsRepository.findOne("Kiwi"));
        listIngredients.add(ingredientsRepository.findOne("Mandarina"));
        listIngredients.add(ingredientsRepository.findOne("Manzana"));
        listIngredients.add(ingredientsRepository.findOne("Melón"));
        dishList.add(new Dish("Ensalada de frutas",200, listIngredients));
    }

    @Override
    public Dish findOne(String name) {
        List<Dish> listDishFilter = dishList.stream().filter(d -> d.getName().equals(name)).toList();
        return listDishFilter.get(0);
    }

    @Override
    public List<Dish> findAll() {
        return dishList;
    }
}
