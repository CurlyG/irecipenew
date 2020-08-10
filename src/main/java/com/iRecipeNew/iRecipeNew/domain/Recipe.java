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
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String directions;


    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;




//    @OneToMany(mappedBy = "recipe")
//    private Set<RecipeIngredient> quantity;

    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;





}