package com.iRecipeNew.iRecipeNew.repository;

import com.iRecipeNew.iRecipeNew.domain.Cuisine;
import com.iRecipeNew.iRecipeNew.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface CuisineRepository extends CrudRepository<Cuisine, Long> {
}
