package edu.ap.facilitytoolspringboot.controllers;

import edu.ap.facilitytoolspringboot.models.Emergency;
import edu.ap.facilitytoolspringboot.models.Report;
import edu.ap.facilitytoolspringboot.repositories.EmergencyRepository;
import edu.ap.facilitytoolspringboot.repositories.ReportRepository;
import edu.ap.facilitytoolspringboot.services.EmergencyService;
import edu.ap.facilitytoolspringboot.services.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@CrossOrigin
public class EmergencyController {

    private static final Logger LOG = LoggerFactory.getLogger(ReportController.class);
    private EmergencyService emergencyService;
    private EmergencyRepository emergencyRepository;

    @Autowired
    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @PostMapping("/emergencies")
    public ResponseEntity<Emergency> postEmergency(@RequestBody Emergency emergency) {
        try {
            Emergency em = emergencyService.create(emergency);
            LOG.info("Created a new Emergency with the id: {}", em.getId());
            return new ResponseEntity<>(em, HttpStatus.CREATED);
        } catch (Exception e) {
            LOG.error("Couldn't create a new emergency", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/emergencies/id")
    public ResponseEntity<Emergency> putEmergency(@RequestBody Emergency emergency) {
        Emergency em = emergencyService.create(emergency);
        return new ResponseEntity<>(em, HttpStatus.CREATED);
    }

}
