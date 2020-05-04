package edu.ap.facilitytoolspringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.facilitytoolspringboot.documents.Melding;
import edu.ap.facilitytoolspringboot.documents.Reactie;
import edu.ap.facilitytoolspringboot.repositories.MeldingRepo;

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

    // Upvoting system
    public Melding toggleUpvote(String id) {
        Optional<Melding> existingDefect = mr.findById(id);

        if (existingDefect.isPresent()) {
            Melding _melding = existingDefect.get();
            boolean isUpvoted = _melding.isUpvoted();

            if (!isUpvoted) {
                _melding.setUpvoted(true);
                int incrementedUpvotes = _melding.getNumberUpvotes() + 1;
                _melding.setNumberUpvotes(incrementedUpvotes);
            } else {
                _melding.setUpvoted(false);
                int decrementedUpvotes = _melding.getNumberUpvotes() - 1;
                _melding.setNumberUpvotes(decrementedUpvotes);
            }
            mr.save(_melding);
            return _melding;
        }
        return null;
    }
}