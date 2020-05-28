package edu.ap.facilitytoolspringboot.services;

import edu.ap.facilitytoolspringboot.models.Emergency;
import edu.ap.facilitytoolspringboot.models.Reaction;
import edu.ap.facilitytoolspringboot.models.Report;
import edu.ap.facilitytoolspringboot.repositories.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmergencyService {

    private EmergencyRepository emergencyRepository;

    @Autowired
    public EmergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    public Emergency create(Emergency emergency) {
        return emergencyRepository.save(emergency);
    }

    public Emergency changeEmergency(String id,Emergency emergency) {
        Optional<Emergency> existingEmergency = emergencyRepository.findById(id);

        if (existingEmergency.isPresent()) {
            Emergency emergency1 = existingEmergency.get();
            emergency1 = emergency;
            emergencyRepository.save(emergency1);
            return emergency1;
        }
        return null;
    }

    public List<Emergency> getAllEmergencies() {
        return emergencyRepository.findAll();
    }


    public Emergency getById(String id) {
        Optional<Emergency> emergency = emergencyRepository.findById(id);
        return emergency.orElse(null);
    }



    public void deleteById(String id) {
        emergencyRepository.deleteById(id);
    }


}
