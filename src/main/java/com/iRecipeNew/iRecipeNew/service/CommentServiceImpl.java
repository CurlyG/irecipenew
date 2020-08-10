package com.iRecipeNew.iRecipeNew.service;

import com.iRecipeNew.iRecipeNew.domain.Comment;
import com.iRecipeNew.iRecipeNew.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Optional<Comment> getCommentByRecipeId(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void deleteCommentByRecipeId(Long id) {
        commentRepository.deleteById(id);

    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);

    }
}
