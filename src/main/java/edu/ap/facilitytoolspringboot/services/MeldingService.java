package edu.ap.facilitytoolspringboot.services;

import edu.ap.facilitytoolspringboot.models.Melding;
import edu.ap.facilitytoolspringboot.repositories.MeldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeldingService {
    @Autowired
    private MeldingRepository meldingRepo;

    public Melding create(Melding m) {
        return meldingRepo.save(new Melding(m));
    }

    public List<Melding> getAlleMeldingen() {
        return meldingRepo.findAll();
    }

    public Melding getMeldingM(String melder) {
        return meldingRepo.findByMelder(melder);
    }

    public void deleteAll() {
        meldingRepo.deleteAll();
    }

    public void delete(String melder) {
        Melding teVerwijderen = meldingRepo.findByMelder(melder);
        meldingRepo.delete(teVerwijderen);
    }

}
