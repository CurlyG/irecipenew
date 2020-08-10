//package com.iRecipeNew.iRecipeNew.controller;
//
//import com.iRecipeNew.iRecipeNew.domain.Comment;
//import com.iRecipeNew.iRecipeNew.domain.Recipe;
//import com.iRecipeNew.iRecipeNew.errors.RecipeNotFoundError;
//import com.iRecipeNew.iRecipeNew.service.CommentService;
//import com.iRecipeNew.iRecipeNew.service.RecipeService;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@Slf4j
//public class CommentController {
//
//    private final Logger logger = LoggerFactory.getLogger(CommentController.class);
//
//    @Autowired
//    CommentService commentService;
//
//    public CommentController(CommentService commentService) {
//        this.commentService = commentService;
//    }
//
//    @GetMapping("/recipe/{id}/comment")
//    public Comment getComment(@PathVariable long recipeId){
//        Optional<Comment> comment = this.commentService.getCommentByRecipeId(recipeId);
//
//        if(!comment.isPresent()){
//            throw new RecipeNotFoundError(recipeId);
//        }
//
//        return comment.get();
//    }
//
//
//    @PostMapping("/recipe/{id}/comment")
//    public void postComment(@RequestBody Comment comment){
//        commentService.createComment(comment);
//    }
//
//
//    @DeleteMapping("/recipe/{id}/comment")
//    public void deleteComment(@PathVariable long recipeId){
//        this.commentService.deleteCommentByRecipeId(recipeId);
//    }
//
//
//
//
//}
