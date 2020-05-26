package edu.ap.facilitytoolspringboot.controllers;

import edu.ap.facilitytoolspringboot.models.Reaction;
import edu.ap.facilitytoolspringboot.models.Report;
import edu.ap.facilitytoolspringboot.services.ReportService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class ReportController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportController.class);
    private ReportService reportService;

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
            List<Report> reports = reportService.getAllReports();
            if (reports.isEmpty()) {
                LOG.info("There are no reports to return");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            LOG.info("Returned all reports");
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Couldn't return the reports", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reports/by-id/{id}")
    public ResponseEntity<Report> getById(@PathVariable("id") String id) {
        try {
            Report report = reportService.getById(id);
            if (report == null) {
                LOG.info("There is no report with the id: {}", id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            LOG.info("Returned the report with id: {}", id);
            return new ResponseEntity<>(report, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Couldn't return the report with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reports/by-location/{location}")
    public ResponseEntity<List<Report>> getByLocation(@PathVariable("location") String location) {
        try {
            List<Report> reports = reportService.getByLocation(location);
            if (reports.isEmpty()) {
                LOG.info("There are no reports with the location: {}", location);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            LOG.info("Returned the reports with the location: {}", location);
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Couldn't return the reports with the location: {}", location, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reports")
    public ResponseEntity<Report> postReport(@RequestBody Report report) {
        try {
            Report rep = reportService.create(report);
            LOG.info("Created a new report with the id: {}", rep.getId());
            return new ResponseEntity<>(rep, HttpStatus.CREATED);
        } catch (Exception e) {
            LOG.error("Couldn't create a new report", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //Not working correctly yet
    @PostMapping("/reports/reactions/{id}")
    public ResponseEntity<Reaction> postReaction(@PathVariable("id") String id, @RequestBody Reaction reaction) {
        try {
            Reaction rea = reportService.saveReactions(id, reaction);
            LOG.info("Added a new reaction to the report with id:");
            return new ResponseEntity<>(rea, HttpStatus.CREATED);
        } catch (Exception e) {
            LOG.error("Couldn't add a new reaction to the report with id:", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    // Upvoting System
    @PutMapping("/reports/upvote/{id}")
    public ResponseEntity<Report> toggleUpvote(@PathVariable("id") String id) {
        try {
            Report report = reportService.toggleUpvote(id);
            if (report != null) {
                LOG.info("Report with id: {} upvoted/downvoted succesfully", id);
                return new ResponseEntity<>(report, HttpStatus.OK);
            } else {
                LOG.info("There is no report with the id: {}", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            LOG.error("Couldn't upvote/downvote the report with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        try {
            reportService.deleteById(id);
            LOG.info("Report with id: {} removed successfully", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            LOG.error("Couldn't remove the report with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
