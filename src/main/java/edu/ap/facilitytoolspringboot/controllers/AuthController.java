package edu.ap.facilitytoolspringboot.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ap.facilitytoolspringboot.exception.ResourceNotFoundException;
import edu.ap.facilitytoolspringboot.models.User;
import edu.ap.facilitytoolspringboot.repositories.UserRepository;
import edu.ap.facilitytoolspringboot.security.CurrentUser;
import edu.ap.facilitytoolspringboot.security.UserPrincipal;
import edu.ap.facilitytoolspringboot.security.oauth2.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/api")
public class AuthController {

    @Autowired
    private ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    private UserRepository userRepository;

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    public AuthController(RestTemplateBuilder restTemplateBuilder, UserRepository userRepository) {
    this.restTemplate = restTemplateBuilder.build();
    this.userRepository = userRepository;
}


    @GetMapping("/user/me")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



    @PutMapping("/role/{id}")
    public User updateRole(@PathVariable String id, @RequestBody User updateForm) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user;

        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            userRepository.save(updateForm);
            return updateForm;
        }
        try {
            String role = updateForm.getRole();
            if (!role.equals(user.getRole())) {
                user.setRole(role);
            }
            userRepository.save(user);
            return user;
        } catch (Exception ex) {
            return user;
        }
    }




    @PutMapping("/role-delete/{id}")
    public User removeRole(@PathVariable String id ) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user;

        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            return null;
        }
        try {
            user.setRole("Medewerker");
            userRepository.save(user);
            return user;
        } catch (Exception ex) {
            return null;
        }
    }

}
