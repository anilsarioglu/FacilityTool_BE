package edu.ap.facilitytoolspringboot.controllers;

import edu.ap.facilitytoolspringboot.models.Reaction;
import edu.ap.facilitytoolspringboot.models.Report;
import edu.ap.facilitytoolspringboot.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("/reports");
    }

    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getAll() {
        try {
            List<Report> reports = reportService.getAll();
            if (reports.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reports/by-id/{id}")
    public ResponseEntity<Report> getById(@PathVariable("id") String id) {
        try {
            Report report = reportService.getById(id);
            if (report == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(report, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reports/by-location/{location}")
    public ResponseEntity<List<Report>> getByLocation(@PathVariable("location") String location) {
        try {
            List<Report> reports = reportService.getByLocation(location);
            if (reports.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reports")
    public ResponseEntity<Report> postReport(@RequestBody Report report) {
        try {
            Report rep = reportService.create(report);
            return new ResponseEntity<>(rep, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //Not working correctly yet
    @PostMapping("/reports/reactions/{id}")
    public ResponseEntity<Reaction> postReaction(@PathVariable("id") String id, @RequestBody Reaction reaction) {
        try {
            Reaction rea = reportService.saveReactions(id, reaction);
            return new ResponseEntity<>(rea, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    // Upvoting System
    @PutMapping("/reports/upvote/{id}")
    public ResponseEntity<Report> toggleUpvote(@PathVariable("id") String id) {
        try {
            Report report = reportService.toggleUpvote(id);
            if (report != null) {
                return new ResponseEntity<>(report, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        try {
            reportService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}