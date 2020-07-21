package com.iRecipeNew.iRecipeNew.repositories;


import com.iRecipeNew.iRecipeNew.domain.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
