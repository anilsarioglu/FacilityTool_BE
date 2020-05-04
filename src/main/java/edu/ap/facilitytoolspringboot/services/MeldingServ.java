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
        Optional<Melding> m = mr.findById(reactie.getId());

        // Haal specifieke reactie op van die melding;
        List<Reactie> r = m.get().getReactie();
        r.add(reactie);

        // System.out.println(m);
        mr.save(m.get());
    }

    // public void saveReactions(Melding melding) {
    // Optional<Melding> m = mr.findById(melding.getId());
    // List<Reactie> reactie = melding.getReactie();
    // m.get().setReactie(reactie);
    // mr.save(melding);

    // List<Reactie> reactie = melding.getReactie();
    // melding.setReactie(reactie);
    // mr.save(m);

    // mr.findById(m.getId());
    // List<Reactie> reactie = new ArrayList<>();
    // reactie.add(m.get)
    // m.setReactie(m.getReactie());
    // m.getReactie();
    // mr.findById(m.getId());
    // List<Reactie> r = m.getReactie();
    // m.setReactie(r);

    // }

    // Optional<Melding> melding = mr.findById(m.getId());
    // return mr.save(melding);

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