package com.iRecipeNew.iRecipeNew.repository;

import com.iRecipeNew.iRecipeNew.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
