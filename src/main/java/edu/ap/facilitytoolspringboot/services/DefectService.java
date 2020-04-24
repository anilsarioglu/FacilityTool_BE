package edu.ap.facilitytoolspringboot.services;

import edu.ap.facilitytoolspringboot.models.Defect;
import edu.ap.facilitytoolspringboot.repositories.DefectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefectService {
    @Autowired
    private DefectRepository defectRepo;

    //Creating dummy Defects
    Defect defect1 = new Defect(1, "Gebroken stoel", 4);
    Defect defect2 = new Defect(2, "Gebroken neus", 0);

    public void seedData() {
        defectRepo.save(defect1);
        defectRepo.save(defect2);
    }

    public List<Defect> getAll() {
        return defectRepo.findAll();
    }

    public Defect toggleUpvote(long id) {
        Optional<Defect> existingDefect = defectRepo.findById(id);

        if (existingDefect.isPresent()) {
            Defect _defect = existingDefect.get();
            boolean isUpvoted = _defect.isUpvoted();

            if (!isUpvoted) {
                _defect.setUpvoted(true);
                int incrementedUpvotes = _defect.getNumberUpvotes() + 1;
                _defect.setNumberUpvotes(incrementedUpvotes);
            } else {
                _defect.setUpvoted(false);
                int decrementedUpvotes = _defect.getNumberUpvotes() - 1;
                _defect.setNumberUpvotes(decrementedUpvotes);
            }
            defectRepo.save(_defect);
            return _defect;
        }
        return null;
    }
}
