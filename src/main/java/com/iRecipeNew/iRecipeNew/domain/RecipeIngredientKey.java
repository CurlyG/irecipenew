package com.iRecipeNew.iRecipeNew.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//composite key class
@Embeddable
@Data
public class RecipeIngredientKey implements Serializable {

    @Column(name = "recipe_id")
    Long recipeId;

    @Column(name = "ingredient_id")
    Long ingredientId;


}
