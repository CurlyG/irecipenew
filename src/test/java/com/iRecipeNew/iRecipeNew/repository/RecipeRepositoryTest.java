package com.iRecipeNew.iRecipeNew.repository;

import com.iRecipeNew.iRecipeNew.domain.*;
import com.iRecipeNew.iRecipeNew.repository.RecipeRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RecipeRepositoryTest {

   // Mockito

//    private static Long id;
//    private static String name;
//    private static Integer prepTimeInMin;
//    private static Integer cookTimeInMin;
//    private static Integer servings;
//    private static String directions;
    private static Difficulty difficulty;
    private static List<Comment> comments;
    private static User user;
    private static Category category;
    private static Cuisine cuisine;
    private static ERole eRole;
    private static Role role;

//    @BeforeClass
//    public static void setUpBeforeClass(){
//        cuisine = new Cuisine("American", new ArrayList<Recipe>());
//        role = new Role(eRole);
//        user = new User("ruzanna@gmail.com", "Ruzanna", "pass", new HashSet<Role>(), new ArrayList<Recipe>());
//    }
//
//
//    @Before
//    public void setup() {
//        List<Comment> comments = new ArrayList<Comment>();
//        Comment comment1 = new Comment("Good recipe", "Ruzanna", recipe);
//        comments.add(comment1);
//
//    }



    @Autowired
    private TestEntityManager entityManager;

    @InjectMocks
    private RecipeRepository recipeRepository;

    @Test
    public void should_find_no_recipes_if_repository_is_empty() {

        Iterable<Recipe> recipes = recipeRepository.findAll();

        assertThat(recipes).isEmpty();

    }

    @Test
    public void should_store_a_recipe() {

        //@InjectMocks
        //@InjectedMock private InvoiceDao invoiceDao;


        //when.DAORepository.get


        Recipe recipe = recipeRepository.save(new Recipe("pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine ));

        assertThat(recipe).hasFieldOrPropertyWithValue("name", "pizza");
        assertThat(recipe).hasFieldOrPropertyWithValue("prepTimeInMin", 15);
        assertThat(recipe).hasFieldOrPropertyWithValue("cookTimeInMin", 25);
        assertThat(recipe).hasFieldOrPropertyWithValue("servings", 6);
        assertThat(recipe).hasFieldOrPropertyWithValue("directions", "Place into the oven");
    }

    @Test
    public void should_find_all_recipes() {

        Recipe recipe1 = new Recipe("pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine);
        entityManager.persist(recipe1);
        Recipe recipe2 = new Recipe("pasta", 35, 25, 2, "Place into the oven", difficulty, comments, user, category, cuisine);
        entityManager.persist(recipe2);
        Recipe recipe3 = new Recipe("taco", 10, 25, 3, "Place into the oven", difficulty, comments, user, category, cuisine);
        entityManager.persist(recipe3);



        Iterable<Recipe> recipes = recipeRepository.findAll();

         assertThat(recipes).hasSize(3).contains(recipe1, recipe2, recipe3);
    }

    @Test
    public void should_find_recipe_by_id() {

        Recipe recipe = new Recipe("pasta", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine );

        entityManager.persist(recipe);

        Recipe findRecipe = recipeRepository.findById(recipe.getId()).get();

        assertThat(findRecipe).isEqualTo(recipe);


    }

    @Test
    public void should_update_recipe_by_id() {
        Recipe recipe1 = new Recipe("pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine );
        entityManager.persist(recipe1);


        Recipe recipe2 = new Recipe("pasta", 25, 29, 2, "Place into the oven", difficulty, comments, user, category, cuisine );
        entityManager.persist(recipe2);

        Recipe recipe3 = new Recipe("taco", 10, 15, 3, "Place into the oven", difficulty, comments, user, category, cuisine );

        Recipe updatedRecipe = recipeRepository.findById(recipe2.getId()).get();
        updatedRecipe.setName(recipe3.getName());
        updatedRecipe.setServings(recipe3.getServings());
        updatedRecipe.setUser(recipe3.getUser());
        updatedRecipe.setPrepTimeInMin(recipe3.getPrepTimeInMin());
        updatedRecipe.setDirections(recipe3.getDirections());
        updatedRecipe.setDifficulty(recipe3.getDifficulty());
        updatedRecipe.setCuisine(recipe3.getCuisine());
        updatedRecipe.setCookTimeInMin(recipe3.getCookTimeInMin());
        updatedRecipe.setComments(recipe3.getComments());
        updatedRecipe.setCategory(recipe3.getCategory());
        updatedRecipe.setQuantity(recipe3.getQuantity());

        recipeRepository.save(updatedRecipe);


        Recipe recipeCheck = recipeRepository.findById(recipe2.getId()).get();

        assertThat(recipeCheck.getId()).isEqualTo(recipe2.getId());
        assertThat(recipeCheck.getName()).isEqualTo(recipe2.getName());
        assertThat(recipeCheck.getServings()).isEqualTo(recipe2.getServings());
        assertThat(recipeCheck.getUser()).isEqualTo(recipe2.getUser());
        assertThat(recipeCheck.getPrepTimeInMin()).isEqualTo(recipe2.getPrepTimeInMin());
        assertThat(recipeCheck.getDirections()).isEqualTo(recipe2.getDirections());
        assertThat(recipeCheck.getDifficulty()).isEqualTo(recipe2.getDifficulty());
        assertThat(recipeCheck.getCuisine()).isEqualTo(recipe2.getCuisine());
        assertThat(recipeCheck.getCookTimeInMin()).isEqualTo(recipe2.getCookTimeInMin());
        assertThat(recipeCheck.getComments()).isEqualTo(recipe2.getComments());
        assertThat(recipeCheck.getCategory()).isEqualTo(recipe2.getCategory());
        assertThat(recipeCheck.getQuantity()).isEqualTo(recipe2.getQuantity());
    }

    @Test
    public void should_delete_recipe_by_id() {

        Recipe recipe1 = new Recipe("pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine);
        entityManager.persist(recipe1);
        Recipe recipe2 = new Recipe("pasta", 35, 25, 2, "Place into the oven", difficulty, comments, user, category, cuisine);
        entityManager.persist(recipe2);
        Recipe recipe3 = new Recipe("taco", 10, 25, 3, "Place into the oven", difficulty, comments, user, category, cuisine);
        entityManager.persist(recipe3);

        recipeRepository.deleteById(recipe2.getId());
        Iterable<Recipe> recipes = recipeRepository.findAll();

        assertThat(recipes).hasSize(2).contains(recipe1, recipe3);


    }



}
