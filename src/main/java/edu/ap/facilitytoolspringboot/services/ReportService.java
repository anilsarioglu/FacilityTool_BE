package edu.ap.facilitytoolspringboot.services;

import java.util.List;
import java.util.Optional;

import edu.ap.facilitytoolspringboot.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.facilitytoolspringboot.models.Reaction;
import edu.ap.facilitytoolspringboot.repositories.ReportRepository;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

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
            List<Reaction> reactions = report.get().getReactions();
            reactions.add(reaction);
            reportRepository.save(report.get());
        }
        return reaction;
    }

    public List<Report> getAll() {
        return reportRepository.findAll();
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
}