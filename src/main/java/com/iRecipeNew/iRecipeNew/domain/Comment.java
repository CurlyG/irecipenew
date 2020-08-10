package com.iRecipeNew.iRecipeNew.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String authorName;


    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}
