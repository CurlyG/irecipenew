package com.iRecipeNew.iRecipeNew.controller;

import com.iRecipeNew.iRecipeNew.repository.RecipeRepository;
import com.iRecipeNew.iRecipeNew.service.RecipeServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.Id;
import javax.transaction.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private RecipeServiceImpl recipeService = new RecipeServiceImpl();


    @Mock
    private RecipeRepository recipeRepository;

    private String recipeJson() {
        return ("{" +
                "\"id\": " + 30 + "," +
                "\"name\": \"" + "pizza" + "\"," +
                "\"prepTimeInMin\": " + 30 + "," +
                "\"cookTimeInMin\": " + 10 + "," +
                "\"servings\": " + 6 + "," +
                "\"directions\": \"" + "Place into the oven" + "\"," +
                "\"difficulty\": \"" + "EASY" + "\"," +
                "\"quantity\": " + "[]" + "," +
                "\"comments\": " + "[]" + "," +
                "\"user\": " + null + "," +
                "\"category\": " + null + "," +
                "\"cuisine\": " + null +
                "}");
    }


    @Test
    @WithMockUser
    public void getRecipesTest() throws Exception {

        MockMvc mvc = mockMvc;

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("http://localhost:8080/api/v1/recipes");

        mvc.perform(request.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.content().string(containsString("cake")));
    }

    @Test
    @WithMockUser
    public void getRecipesByIdTest() throws Exception {

        MockMvc mvc = mockMvc;

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("http://localhost:8080/api/v1/recipes/56");


        mvc.perform(request.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.content().string(containsString("56")));
    }


        @Test
        @WithMockUser
        @Transactional
        public void createRecipesTest() throws Exception {

        MockMvc mvc = mockMvc;

            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .post("http://localhost:8080/api/v1/recipes").
                    contentType(MediaType.APPLICATION_JSON)
                    .content(recipeJson());


            mvc.perform(request.accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().is(201));

    }


    @Test
    @WithMockUser
    @Transactional
    public void deleteRecipeByIdTest() throws Exception {

        MockMvc mvc = mockMvc;

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .delete("http://localhost:8080/api/v1/recipes/56");

        mvc.perform(request).andExpect(status().is(200));
    }



    @Test
    @WithMockUser
    @Transactional
    public void putRecipeByIdTest() throws Exception {

        MockMvc mvc = mockMvc;

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .put("http://localhost:8080/api/v1/recipes/56")
                .contentType(MediaType.APPLICATION_JSON)
                .content(recipeJson());

        mvc.perform(request.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    @WithMockUser
    @Transactional
    public void patchRecipeByIdTest() throws Exception {

        MockMvc mvc = mockMvc;

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .patch("http://localhost:8080/api/v1/recipes/57")
                .contentType(MediaType.APPLICATION_JSON)
                .content(recipeJson());

        mvc.perform(request.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

    }

}
