package co.com.mercadolibre.calorias.repository;

import co.com.mercadolibre.calorias.entity.Ingredient;

public interface IIngredientRepository {

    Ingredient findIngredientByName(String name);
}
