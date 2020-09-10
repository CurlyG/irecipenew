package com.iRecipeNew.iRecipeNew.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @Size(min = 8, message = "Minimum password length: 8 characters")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
     private Set<Role> roles;


    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;


    public User(String email, @Size(min = 4, max = 255, message = "Minimum username length: 4 characters") String username, @Size(min = 8, message = "Minimum password length: 8 characters") String password, Set<Role> roles, List<Recipe> recipes) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.recipes = recipes;
    }

    public User(){};


}



