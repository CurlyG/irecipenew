package com.iRecipeNew.iRecipeNew.service;

import com.iRecipeNew.iRecipeNew.domain.Comment;
import com.iRecipeNew.iRecipeNew.domain.Recipe;

import java.util.Optional;

public interface CommentService {

    Optional<Comment> getCommentByRecipeId(Long id);

    void deleteCommentByRecipeId(Long id);
    void createComment(Comment comment);


}
