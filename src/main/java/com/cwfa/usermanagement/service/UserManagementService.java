package com.cwfa.usermanagement.service;

import com.cwfa.usermanagement.domain.dto.UserDto;
import com.cwfa.usermanagement.domain.entity.User;
import com.cwfa.usermanagement.exception.GenericException;
import com.cwfa.usermanagement.repository.UserManagementRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserManagementService {

    @Autowired
    private UserManagementRepository userManagementRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<User> getUsers() {
        Optional<List<User>> optUsers = userManagementRepository.findUsers();
        if (optUsers.isPresent()) {
            return optUsers.get();
        } else {
            throw new GenericException(HttpStatus.NOT_FOUND, "No users were found");
        }
    }

    public User getUserByUsername(String username) {
        Optional<User> optUser = userManagementRepository.findUserByUsername(username);
        if (optUser.isPresent()) {
            return optUser.get();
        } else {
            throw new GenericException(HttpStatus.NOT_FOUND, String.format("No user was found with username %s", username));
        }
    }

    @Transactional
    public ResponseEntity<HttpStatus> createUser(UserDto user) {
        Optional<User> origUser = userManagementRepository.findUserByUsername(user.getUsername());
        if(origUser.isEmpty()) {
            User newUser = modelMapper.map(user, User.class);
            userManagementRepository.save(newUser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public ResponseEntity<HttpStatus> deleteUser(String username) {
        Optional<User> optUser = userManagementRepository.findUserByUsername(username);
        if (optUser.isPresent()) {
            userManagementRepository.deleteByUsername(username);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new GenericException(HttpStatus.NOT_FOUND, String.format("No user was found with username %s", username));
        }
    }
}
