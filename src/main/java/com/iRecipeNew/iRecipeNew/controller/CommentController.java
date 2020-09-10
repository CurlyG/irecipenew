package com.iRecipeNew.iRecipeNew.controller;

import com.iRecipeNew.iRecipeNew.domain.Comment;
import com.iRecipeNew.iRecipeNew.domain.Recipe;
import com.iRecipeNew.iRecipeNew.errors.RecipeNotFoundError;
import com.iRecipeNew.iRecipeNew.service.CommentService;
import com.iRecipeNew.iRecipeNew.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("api/v1/comments")
public class CommentController {

    private final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Comment>> getCommentById(@PathVariable(required = true) long id){
        Optional<Comment> comment = this.commentService.getCommentById(id);

        if(!comment.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteCommentById(@PathVariable long id){

        if (this.commentService.deleteCommentId(id)){
            return ResponseEntity.ok().body("Comment successfully deleted!");
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
