package edu.ap.facilitytoolspringboot.services;

import edu.ap.facilitytoolspringboot.models.Emergency;
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

    /*public Emergency changeEmergency(String id, Emergency em) {
        Optional<Emergency> emergency = emergencyRepository.findById(id);

        return null;
    }*/


   /* public Emergency changeEmergency(String id) {
        Optional<Emergency> existingEmergency = reportRepository.findById(id);

        Emergency emergency = existingEmergency.get();
        emergency.setEmergencyContactsType();

        emergencyRepository.save(emergency);
        return report;

    }*/

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
