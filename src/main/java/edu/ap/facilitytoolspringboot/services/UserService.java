package edu.ap.facilitytoolspringboot.services;

import edu.ap.facilitytoolspringboot.models.User;
import edu.ap.facilitytoolspringboot.repositories.UserRepository;
import edu.ap.facilitytoolspringboot.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private ReportService reportService;

    @Autowired
    public UserService(UserRepository userRepository, ReportService reportService) {
        this.userRepository = userRepository;
        this.reportService = reportService;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getCurrentUser(UserPrincipal userPrincipal) {
        Optional<User> user =  userRepository.findById(userPrincipal.getId());
        return user.orElse(null);
    }

    public User updateRole(String id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            String role = updatedUser.getRole();
            if (!role.equals(user.getRole())) {
                user.setRole(role);
                userRepository.save(user);
            }
            return user;
        } else {
            userRepository.save(updatedUser);
            return updatedUser;
        }
    }

    public User removeRole(String id) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setRole("Medewerker");
            userRepository.save(user);
            return user;
        } else {
            return null;
        }
    }
}
