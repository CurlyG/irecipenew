package com.iRecipeNew.iRecipeNew.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role(){}

    public Role(ERole name) {
        this.name = name;
    }
}
