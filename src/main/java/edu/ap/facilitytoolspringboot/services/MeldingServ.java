package edu.ap.facilitytoolspringboot.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.ap.facilitytoolspringboot.documents.Melding;
import edu.ap.facilitytoolspringboot.documents.Reactie;
import edu.ap.facilitytoolspringboot.repositories.MeldingRepo;
import edu.ap.facilitytoolspringboot.models.Status;

@Service
public class MeldingServ {

    @Autowired
    private MeldingRepo mr;

    public Melding getMelding(String id) {
        return mr.findById(id).get();
    }

    public Melding create(Melding m) {
        return mr.save(m);
    }

    public void saveReactions(Reactie reactie) {
        // Toont hier volledige melding met ID;
        Optional<Melding> m = mr.findById(reactie.getMessageId());

        // Haal specifieke reactie op van die melding;
        List<Reactie> r = m.get().getReactie();

        // Voeg die reactie toe;
        r.add(reactie);

        // ophalen en opslaan;
        mr.save(m.get());
    }

    public List<Melding> getAlleMeldingen() {
        return mr.findAll();
    }

    public Melding getMeldingM(String melder) {
        return mr.findByMelder(melder);
    }

    public List<Melding> getByLocatie(String locatie) {
        return mr.findByLocatie(locatie);
    }

    public Optional<Melding> getById(String id) {
        return mr.findById(id);
    }

    public void deleteAll() {
        mr.deleteAll();
    }

    public void delete(String melder) {
        Melding mm = mr.findByMelder(melder);
        mr.delete(mm);
    }

    public void deleteById(String id) {
        mr.deleteById(id);
    }

    // public Melding updateMelding(Melding m) {
    // Optional<Melding> melding = mr.findById(m.getId());
    // return mr.save(melding);
    // }

}