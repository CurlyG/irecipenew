package com.iRecipeNew.iRecipeNew.repository;

import com.iRecipeNew.iRecipeNew.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>

{
}
