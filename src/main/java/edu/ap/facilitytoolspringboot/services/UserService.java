package edu.ap.facilitytoolspringboot.services;

import edu.ap.facilitytoolspringboot.models.Report;
import edu.ap.facilitytoolspringboot.models.User;
import edu.ap.facilitytoolspringboot.repositories.UserRepository;
import edu.ap.facilitytoolspringboot.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    private User getById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User getCurrentUser(UserPrincipal userPrincipal) {
        Optional<User> user =  userRepository.findById(userPrincipal.getId());
        return user.orElse(null);
    }

    public List<Report> getAllReports(String userId){
        User user = getById(userId);
        List<String> reportIds = user.getAssignedReportsId();
        List<Report> reports = new ArrayList<>();
        for (String reportId : reportIds) {
            reports.add(reportService.getById(reportId));
        }
        return reports;
    }

    public String addAssignedReportId(String userId, String reportId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User user1 = user.get();
            if (!user1.isReportAlreadyAssigned(reportId)) {
                List<String> userList = user1.getAssignedReportsId();
                userList.add(reportId);
                user1.setAssignedReportsId(userList);
                userRepository.save(user1);
                return reportId;
            }
        }
        return null;
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
