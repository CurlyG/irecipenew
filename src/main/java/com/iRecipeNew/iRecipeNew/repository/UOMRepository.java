package com.iRecipeNew.iRecipeNew.repository;

import com.iRecipeNew.iRecipeNew.domain.Recipe;
import com.iRecipeNew.iRecipeNew.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UOMRepository extends CrudRepository<UnitOfMeasure, Long> {
}
