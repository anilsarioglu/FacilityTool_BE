package edu.ap.facilitytoolspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.ap.facilitytoolspringboot.documents.Locatie;
import edu.ap.facilitytoolspringboot.repositories.LocatieRepo;
import edu.ap.facilitytoolspringboot.services.LocatieServ;

@RestController
@CrossOrigin
public class LocatieCtrl {

    @Autowired
    private LocatieServ lsrv;

    @Autowired
    private LocatieRepo lp;

    @GetMapping("/getAllLocaties")
    public List<Locatie> getAll() {
        return lp.findAll();
    }

    @GetMapping("/findByNaam/{naam}")
    public List<Locatie> findByNaam(@PathVariable("naam") String naam) {
        return lp.findByNaam(naam);
    }

    @GetMapping("/findByLokaal/{lokaal}")
    public List<Locatie> findByLokaal(@PathVariable("lokaal") String lokaal) {
        return lsrv.getByLokaal(lokaal);
    }

    @GetMapping("/findByCampus/{campus}")
    public List<Locatie> getByCampus(@PathVariable("campus") String campus) {
        return lsrv.getByCampus(campus);
    }

    @GetMapping("/findByVerdieping/{verdieping}")
    public List<Locatie> getByVerdieping(@PathVariable("verdieping") int verdieping) {
        return lsrv.getByVerdieping(verdieping);
    }

}