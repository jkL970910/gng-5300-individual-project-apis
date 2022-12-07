package com.gng5300.individualprojectapis.controller;

import com.gng5300.individualprojectapis.model.User;
import com.gng5300.individualprojectapis.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User userLogin(@Argument String username, @Argument String password) {
        return userService.userLogin(username, password);
    }

    @QueryMapping
    public User getUserByUsername(@Argument String username) {
        return userService.findUserByUsername(username);
    }

    @MutationMapping
    public User addNewUser(@Argument String username, @Argument String password) {
        return userService.createNewUser(username, password);
    }

    @MutationMapping
    public User likePhoto(@Argument String username, @Argument String photoTitle) {
        return userService.addLikedPhoto(username, photoTitle);
    }

    @MutationMapping
    public User unLikePhoto(@Argument String username, @Argument String photoTitle) {
        return userService.removeLikedPhoto(username, photoTitle);
    }
}