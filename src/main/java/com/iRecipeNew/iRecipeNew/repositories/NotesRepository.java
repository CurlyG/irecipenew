package com.iRecipeNew.iRecipeNew.repositories;


import com.iRecipeNew.iRecipeNew.domain.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long> {
}
