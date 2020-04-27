package edu.ap.facilitytoolspringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.facilitytoolspringboot.documents.Locatie;
import edu.ap.facilitytoolspringboot.repositories.LocatieRepo;

@Service
public class LocatieServ {

    @Autowired
    private LocatieRepo lr;

    public Locatie create(String campus, int verdieping, String lokaal, String naam) {
        return lr.save(new Locatie(campus, verdieping, lokaal, naam));

    }

    public List<Locatie> getAll() {
        return lr.findAll();
    }

    public List<Locatie> getByNaam(String naam) {
        return lr.findByNaam(naam);
    }

    public List<Locatie> getByLokaal(String lokaal) {
        return lr.findByLokaal(lokaal);
    }

    public List<Locatie> getByCampus(String campus) {
        return lr.findByCampus(campus);
    }

    public List<Locatie> getByVerdieping(int verdieping) {
        return lr.findByVerdieping(verdieping);
    }

}