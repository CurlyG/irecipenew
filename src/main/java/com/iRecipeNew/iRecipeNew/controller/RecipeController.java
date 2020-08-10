//package com.iRecipeNew.iRecipeNew.controller;
//
//import com.iRecipeNew.iRecipeNew.domain.Recipe;
//import com.iRecipeNew.iRecipeNew.errors.RecipeNotFoundError;
//import com.iRecipeNew.iRecipeNew.service.RecipeService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@Slf4j
//public class RecipeController {
//
//
//    @Autowired
//    RecipeService recipeService;
//
//    public RecipeController(RecipeService recipeService) {
//        this.recipeService = recipeService;
//    }
//
//    @GetMapping("/recipes")
//    public List<Recipe> getRecipes(){
//        return recipeService.getAllRecipes();
//    }
//
//    @GetMapping("/recipes/{id}")
//    public Recipe getRecipeById(@PathVariable long recipeId){
//        Optional<Recipe> recipe = this.recipeService.getRecipeById(recipeId);
//
//        if(!recipe.isPresent()){
//            throw new RecipeNotFoundError(recipeId);
//        }
//
//        return recipe.get();
//    }
//
//    @PostMapping("/recipes")
//    public void postRecipe(@RequestBody Recipe recipe){
//        recipeService.createRecipe(recipe);
//    }
//
//
//    @DeleteMapping("/recipes/{id}")
//    public void deleteRecipeById(@PathVariable long id){
//        this.recipeService.deleteRecipeById(id);
//    }
//
//    @PutMapping("/recipes/{id}")
//    public void putRecipeById(@PathVariable long id, @RequestBody Recipe recipe){
//        this.recipeService.updateRecipeById(recipe, id);
//
//    }
//
//    @PatchMapping("/recipes/{id}")
//    public void patchRecipeById(@PathVariable  long id, @RequestBody Recipe recipe){
//        this.recipeService.replaceRecipeById(recipe, id);
//
//    }
//
//
//
//
//
//
//}
