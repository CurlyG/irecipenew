package com.iRecipeNew.iRecipeNew.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@EqualsAndHashCode
@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("prepTimeInMin")
    private Integer prepTimeInMin;
    @JsonProperty("cookTimeInMin")
    private Integer cookTimeInMin;
    @JsonProperty("servings")
    private Integer servings;

    @Lob
    @JsonProperty("directions")
    private String directions;


    @Enumerated(value = EnumType.STRING)
    @JsonProperty("difficulty")
    private Difficulty difficulty;




    @OneToMany(mappedBy = "recipe")
    @JsonProperty("quantity")
    private Set<RecipeIngredient> quantity;

    @OneToMany(mappedBy = "recipe")
    @JsonProperty("comments")
    private List<Comment> comments;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonProperty("user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonProperty("category")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuisine_id")
    @JsonProperty("cuisine")
    private Cuisine cuisine;


    public Recipe(){}

    public Recipe(Long id, String name, Integer prepTimeInMin, Integer cookTimeInMin, Integer servings, String directions, Difficulty difficulty, List<Comment> comments, User user, Category category, Cuisine cuisine) {
        this.id = id;
        this.name = name;
        this.prepTimeInMin = prepTimeInMin;
        this.cookTimeInMin = cookTimeInMin;
        this.servings = servings;
        this.directions = directions;
        this.difficulty = difficulty;
        this.comments = comments;
        this.user = user;
        this.category = category;
        this.cuisine = cuisine;
    }
    public Recipe(String name, Integer prepTimeInMin, Integer cookTimeInMin, Integer servings, String directions, Difficulty difficulty, List<Comment> comments, User user, Category category, Cuisine cuisine) {
        this.name = name;
        this.prepTimeInMin = prepTimeInMin;
        this.cookTimeInMin = cookTimeInMin;
        this.servings = servings;
        this.directions = directions;
        this.difficulty = difficulty;
        this.comments = comments;
        this.user = user;
        this.category = category;
        this.cuisine = cuisine;
    }


}