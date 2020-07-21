package com.iRecipeNew.iRecipeNew.repositories;

import com.iRecipeNew.iRecipeNew.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
