package com.iRecipeNew.iRecipeNew.service;


import com.iRecipeNew.iRecipeNew.domain.Recipe;
import com.iRecipeNew.iRecipeNew.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;


    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();

    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public void updateRecipeById(Recipe recipe, Long id) {

    }

    @Override
    public void replaceRecipeById(Recipe recipe, Long id) {

    }

    @Override
    public void deleteRecipeById(Long id) {

        recipeRepository.deleteById(id);

    }

    @Override
    public void createRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
