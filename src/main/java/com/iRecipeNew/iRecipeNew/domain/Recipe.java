package com.iRecipeNew.iRecipeNew.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer prepTimeInMin;
    private Integer cookTimeInMin;
    private Integer servings;

    @Lob
    private String directions;


    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;




    @OneToMany(mappedBy = "recipe")
    private Set<RecipeIngredient> quantity;

    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;


    public Recipe(){}

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