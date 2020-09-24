package com.iRecipeNew.iRecipeNew.service;

import com.iRecipeNew.iRecipeNew.domain.*;
import com.iRecipeNew.iRecipeNew.repository.RecipeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.*;
import static org.hamcrest.CoreMatchers.is;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class RecipeServiceTest {


    @InjectMocks
    private RecipeServiceImpl recipeService = new RecipeServiceImpl();


    @Mock
    private RecipeRepository recipeRepository;


    private static Long id;
    private static String name;
    private static Integer prepTimeInMin;
    private static Integer cookTimeInMin;
    private static Integer servings;
    private static String directions;
    private static Difficulty difficulty;
    private static List<Comment> comments;
    private List<Recipe> recipes;
    private static User user;
    private static Category category;
    private static Cuisine cuisine;
    private static Recipe recipe;
    private static ERole eRole;
    private static Role role;


//    @BeforeClass
//    public static void setUpBeforeClass(){
//        //setup difficulty
//        difficulty = Difficulty.EASY;
//
//        //setup comment
//        Comment comment1 = new Comment("Good recipe", "Ruzanna", recipe);
//        Comment comment2 = new Comment("I love it", "Jack", recipe);
//        comments.add(comment1);
//        comments.add(comment2);
//
//        //setup user
//        List<Recipe> recipes = new ArrayList<>();
//        Set<Role> roles = new HashSet<Role>();
//        user = new User("ruzanna@gmail.com", "Ruzanna", "pass", roles, recipes);
//
//        //setup cuisine
//        cuisine = new Cuisine("American", recipes);
//
//        //setup recipe
//        recipe = new Recipe("pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine );
//        id =1L;
//        recipe.setId(id);
//    }


        @BeforeEach
        public void setMockOutput() {

            Recipe recipe1 = new Recipe(1L, "pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine);
            Recipe recipe2 = new Recipe(2L, "pasta", 35, 20, 2, "Put some butter", difficulty, comments, user, category, cuisine);
            Recipe recipe3 = new Recipe(3L, "taco", 10, 30, 3, "Put your favorite spices", difficulty, comments, user, category, cuisine);
            recipes = new ArrayList<>();
            recipes.add(recipe1);
            recipes.add(recipe2);
            recipes.add(recipe3);

            when(recipeRepository.findAll()).thenReturn(recipes);
            when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe1));
            when(recipeRepository.findById(2L)).thenReturn(Optional.of(recipe2));
            when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe1);
            when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe2);

        }

        @Test
        public void getAllRecipesTest(){
//            Recipe recipe1 = new Recipe(1L, "pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine);
//            Recipe recipe2 = new Recipe(2L, "pasta", 35, 20, 2, "Put some butter", difficulty, comments, user, category, cuisine);
//            Recipe recipe3 = new Recipe(3L, "taco", 10, 30, 3, "Put your favorite spices", difficulty, comments, user, category, cuisine);
//           List<Recipe> recipes = new ArrayList<>();
//            recipes.add(recipe1);
//            recipes.add(recipe2);
//            recipes.add(recipe3);
            assertEquals(3, recipeService.getAllRecipes().size());

        }

    @Test
    public void getRecipeByIdTest(){
        Optional<Recipe> recipe1 = Optional.of(new Recipe(1L, "pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine));
        assertEquals(recipe1, recipeService.getRecipeById(1L));


        Optional<Recipe> test = recipeService.getRecipeById(1L);
        assert(test.isPresent());

    }

    @Test
    public void updateRecipeByIdTest(){
        Recipe recipe1 =  recipeService.getRecipeById(1L).get();
        Recipe recipe2 =  recipeService.getRecipeById(2L).get();

       recipeService.updateRecipeById(1L, recipe2);

        assert(recipeService.getRecipeById(1L).get().getName().equals(recipe2.getName()));




    }

//    @Test
//    public void deleteRecipeByIdTest(){
//        Recipe recipe1 = new Recipe(1L, "pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine);
//
//
//        doAnswer((arguments) -> {
//            assertEquals(recipe1, arguments.getArgument(0));
//            return null;
//        }).when(recipeRepository).deleteById(1L);
//        recipeService.deleteRecipeById(1L);
//
//        verify(recipeRepository, times(1)).deleteById(1L);
//
//
//    }

    @Test
    public void createRecipeTest(){
        Recipe recipe1 = new Recipe(1L, "pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine);


        doAnswer((arguments) -> {
            assertEquals(recipe1, arguments.getArgument(0));
            return null;
        }).when(recipeRepository).save(any(Recipe.class));
        recipeService.createRecipe(recipe1);

        verify(recipeRepository, times(1)).save(recipe1);


    }



}
