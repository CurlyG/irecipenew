package com.iRecipeNew.iRecipeNew.repository;

import com.iRecipeNew.iRecipeNew.domain.Ingredient;
import com.iRecipeNew.iRecipeNew.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
