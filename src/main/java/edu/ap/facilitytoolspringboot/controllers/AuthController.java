package edu.ap.facilitytoolspringboot.controllers;


import edu.ap.facilitytoolspringboot.models.User;
import edu.ap.facilitytoolspringboot.security.CurrentUser;
import edu.ap.facilitytoolspringboot.security.UserPrincipal;
import edu.ap.facilitytoolspringboot.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/api")
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAll();
            if (users.isEmpty()) {
                LOG.info("There are no users to return");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            LOG.info("Returned all users");
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Couldn't return the users", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/me")
    public ResponseEntity<User> getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        try {
            User currentUser = userService.getCurrentUser(userPrincipal);
            if (currentUser == null) {
                LOG.info("There is no currentUser");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            LOG.info("Returned the currentUser");
            return new ResponseEntity<>(currentUser, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Couldn't return the employee", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<User> updateRole(@PathVariable String id, @RequestBody User updatedUser) {
        try {
            User user = userService.updateRole(id, updatedUser);
            LOG.info("User with id: {} updated/created successfully", id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Couldn't update/create the user with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/role-delete/{id}")
    public ResponseEntity<User> removeRole(@PathVariable String id ) {
        try {
            User user = userService.removeRole(id);
            if (user != null) {
                LOG.info("User with id: {} updated/created successfully", id);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                LOG.info("There is no user with the id: {}", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            LOG.error("Couldn't remove the role of the user with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
