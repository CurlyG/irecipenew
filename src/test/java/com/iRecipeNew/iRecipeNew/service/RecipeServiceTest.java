package com.iRecipeNew.iRecipeNew.service;

import com.iRecipeNew.iRecipeNew.controller.UserController;
import com.iRecipeNew.iRecipeNew.domain.*;
import com.iRecipeNew.iRecipeNew.repository.UserRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@RunWith(SpringRunner.class)
public class RecipeServiceTest {

    private UserRepository repository = Mockito.mock(UserRepository.class);
    private UserService victim;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private static Long id;
    private static String name;
    private static Integer prepTimeInMin;
    private static Integer cookTimeInMin;
    private static Integer servings;
    private static String directions;
    private static Difficulty difficulty;
    private static Comment comment;
    private static User user;
    private static Category category;
    private static Cuisine cuisine;
    private static Recipe recipe;
    private static ERole eRole;
    private static Role role;


    @BeforeClass
    public static void setUpBeforeClass(){
        cuisine = new Cuisine("American", new ArrayList<Recipe>());
        role = new Role(eRole);
        user = new User("ruzanna@gmail.com", "Ruzanna", "pass", new HashSet<Role>(), new ArrayList<Recipe>());
    }


    @Before
    public void setup() {
        List<Comment> comments = new ArrayList<Comment>();
        Comment comment1 = new Comment("Good recipe", "Ruzanna", recipe);
        comments.add(comment1);
        recipe = new Recipe("pizza", 15, 25, 6, "Place into the oven", difficulty, comments, user, category, cuisine );
        id =1L;
        recipe.setId(id);
    }


}
