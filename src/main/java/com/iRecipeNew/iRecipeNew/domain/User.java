package com.iRecipeNew.iRecipeNew.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String userName;
    private String email;


    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;




}



