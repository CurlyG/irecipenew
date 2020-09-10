package com.iRecipeNew.iRecipeNew.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "cuisine")
    private List<Recipe> recipes;

    public Cuisine(String name, List<Recipe> recipes) {
        this.name = name;
        this.recipes = recipes;
    }
}



