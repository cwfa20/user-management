package com.cwfa.usermanagement.web;

import com.cwfa.usermanagement.domain.entity.User;
import com.cwfa.usermanagement.repository.UserManagementRepository;
import com.cwfa.usermanagement.service.UserManagementService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public class UserManagementControllerTest {

    @InjectMocks
    private UserManagementController userManagementController;
    @Mock
    private UserManagementService userManagementService;
    @Mock
    private UserManagementRepository userManagementRepository;

    @BeforeMethod
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getUsers_shouldRetrieveAllUsersFromDb() {
        User user1 = User.builder()
                .firstName("Joe")
                .lastName("Bloggs")
                .username("jbloggs")
                .password("changeme")
                .dateOfBirth(LocalDate.of(2000,3,4))
                .articlesRead(3)
                .build();
        User user2 = User.builder()
                .firstName("John")
                .lastName("Doe")
                .username("JD99")
                .password("p@ssw0rd")
                .dateOfBirth(LocalDate.of(1999,10,26))
                .articlesRead(3)
                .build();
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        when(userManagementService.getUsers()).thenReturn(users);
        assertEquals(userManagementController.getUsers(), new ResponseEntity<>(HttpStatus.CREATED));
    }

    @Test
    public void getUserByUsername_shouldRetrieveUserFromDb_whenUserExistsWithThisUsername() {
        /*
            TODO - complete test
         */
    }

    @Test
    public void createUser_shouldCreateANewUser_whenUserDoesNotExistWithThisUsername() {
        /*
            TODO - complete test
         */
    }

    @Test
    public void deleteUser_shouldDeleteUserFromDb_whenUserExistsWithThisUsername() {
        /*
            TODO - complete test
         */
    }
}
