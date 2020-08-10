package com.iRecipeNew.iRecipeNew.service;

import com.iRecipeNew.iRecipeNew.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface RecipeService {

    List<Recipe> getAllRecipes();
    Optional<Recipe> getRecipeById(Long id);

    void updateRecipeById(Recipe recipe, Long id);
    void replaceRecipeById(Recipe recipe, Long id);
    void deleteRecipeById(Long id);
    void createRecipe(Recipe recipe);


}
