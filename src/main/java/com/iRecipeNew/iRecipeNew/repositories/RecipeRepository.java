package com.iRecipeNew.iRecipeNew.repositories;


import com.iRecipeNew.iRecipeNew.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
