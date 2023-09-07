package com.cwfa.usermanagement.web;

import com.cwfa.usermanagement.domain.dto.UserDto;
import com.cwfa.usermanagement.domain.entity.User;
import com.cwfa.usermanagement.service.UserManagementService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RestController for management of users
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/usermanagement")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    /**
     * getUsers method to get all users
     *
     * @return ResponseEntity
     */
    @Operation(summary = "get all users")
    @GetMapping("/getUsers")
    public ResponseEntity<HttpStatus> getUsers() {
        userManagementService.getUsers();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * getUser method to get a user with the provided username
     *
     * @param username
     * @return User
     */
    @Operation(summary = "get user by username")
    @GetMapping("/getUser")
    public User getUserByUsername(@RequestBody String username) {
        return userManagementService.getUserByUsername(username);
    }

    /**
     * createUser method to create a new user
     *
     * @param user
     * @return
     */
    @Operation(summary = "create a user")
    @PostMapping("/createUser")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDto user) { return userManagementService.createUser(user);}

    /**
     * deleteUser method to delete a user
     *
     * @param username
     * @return
     */
    @Operation(summary = "delete a user")
    @PostMapping("/deleteUser")
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody String username) { return userManagementService.deleteUser(username);}
}
