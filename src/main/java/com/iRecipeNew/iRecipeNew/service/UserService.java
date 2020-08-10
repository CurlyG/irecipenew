package com.iRecipeNew.iRecipeNew.service;

import com.iRecipeNew.iRecipeNew.domain.Recipe;
import com.iRecipeNew.iRecipeNew.domain.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long id);

    void updateUserById(User user, Long id);
    void replaceUserById(User user, Long id);
    void deleteUserById(Long id);
    void createUser(User user);

}
