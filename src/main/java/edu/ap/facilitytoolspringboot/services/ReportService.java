package edu.ap.facilitytoolspringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.ap.facilitytoolspringboot.models.Report;
import edu.ap.facilitytoolspringboot.models.enums.EnumStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.facilitytoolspringboot.models.Reaction;
import edu.ap.facilitytoolspringboot.repositories.ReportRepository;

@Service
public class ReportService {
    private ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report create(Report report) {
        return reportRepository.save(report);
    }

    public Reaction saveReactions(String id, Reaction reaction) {
        Optional<Report> report = reportRepository.findById(id);
        if (report.isPresent()){
            Report rep = report.get();
            List<Reaction> reactionList = rep.getReactions();
            reactionList.add(reaction);
            rep.setReactions(reactionList);
            reportRepository.save(rep);
        }
        return reaction;
    }

    public List<Report> getAllReports() {
        List<Report> allReports = reportRepository.findAll();
        List<Report> reportsNotInArchive = new ArrayList<>();
        for (Report report : allReports) {
            if (report.getStatus() != EnumStatus.BEËINDIGD && report.getStatus() != EnumStatus.GEANNULEERD
            && report.getStatus() != EnumStatus.WORDT_NIET_UITGEVOERD) {
                reportsNotInArchive.add(report);
            }
        }
        return reportsNotInArchive;
    }

    public Report getByReporter(String reporter) {
        return reportRepository.findByReporter(reporter);
    }

    public List<Report> getByLocation(String location) {
        return reportRepository.findByLocation(location);
    }

    public Report getById(String id) {
        Optional<Report> report = reportRepository.findById(id);
        return report.orElse(null);
    }

    // Archive
    public List<Report> getReportsForArchive(String type){
        List<Report> allReports = reportRepository.findAll();
        List<Report> reportsForArchive = new ArrayList<>();
        for (Report report : allReports) {
            if (report.getType().trim().equals(type) && (
                    report.getStatus() == EnumStatus.BEËINDIGD  ||
                    report.getStatus() == EnumStatus.GEANNULEERD ||
                    report.getStatus() == EnumStatus.WORDT_NIET_UITGEVOERD)
            ) {
                reportsForArchive.add(report);
            }
        }
        return reportsForArchive;
    }

    public void deleteAll() {
        reportRepository.deleteAll();
    }

    public void deleteByReporter(String reporter) {
        Report report = reportRepository.findByReporter(reporter);
        reportRepository.delete(report);
    }

    public void deleteById(String id) {
        reportRepository.deleteById(id);
    }

    // Upvoting system
    public Report toggleUpvote(String id) {
        Optional<Report> existingDefect = reportRepository.findById(id);

        if (existingDefect.isPresent()) {
            Report report = existingDefect.get();
            boolean isUpvoted = report.isUpvoted();

            if (!isUpvoted) {
                report.setUpvoted(true);
                int incrementedUpvotes = report.getNumberUpvotes() + 1;
                report.setNumberUpvotes(incrementedUpvotes);
            } else {
                report.setUpvoted(false);
                int decrementedUpvotes = report.getNumberUpvotes() - 1;
                report.setNumberUpvotes(decrementedUpvotes);
            }
            reportRepository.save(report);
            return report;
        }
        return null;
    }

    // statusChange System
    public Report changeStatus(String id, EnumStatus status) {
        Optional<Report> existingDefect = reportRepository.findById(id);

        if (existingDefect.isPresent()) {
            Report report = existingDefect.get();
            report.setStatus(status);
            
            reportRepository.save(report);
            return report;
        }
        return null;
    }
}