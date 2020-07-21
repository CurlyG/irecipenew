package com.iRecipeNew.iRecipeNew.repositories;

import com.iRecipeNew.iRecipeNew.domain.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CuisineRepository extends CrudRepository<Cuisine, Long> {
}
