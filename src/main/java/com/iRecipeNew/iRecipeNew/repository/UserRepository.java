package com.iRecipeNew.iRecipeNew.repository;

import com.iRecipeNew.iRecipeNew.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
