package edu.ap.facilitytoolspringboot.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Base64.Encoder;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.PostPersist;

import org.bson.Document;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.ap.facilitytoolspringboot.documents.Melding;
import edu.ap.facilitytoolspringboot.repositories.MeldingRepo;
import edu.ap.facilitytoolspringboot.services.MeldingServ;
import edu.ap.facilitytoolspringboot.models.Status;

@Controller
@CrossOrigin
public class MeldingCtrl {

    @Autowired
    private MeldingServ ms;

    @Autowired
    private MeldingRepo mr;

    @GetMapping("/")
    public String index() {
        return "redirect:allMeldingen";
    }

    @GetMapping("/allMeldingen")
    public String getAllMeldingen() {
        return "melding";
    }

    @GetMapping("/lijst")
    public String getAllMeldingen(Model m) {
        m.addAttribute("meldingen", mr.findAll());
        return "lijst";
    }

    @ResponseBody
    @PostMapping(value = "/melding")
    public Melding postMelding(@RequestBody Melding melding) {
        return ms.create(melding);
    }

    @ResponseBody
    @RequestMapping(value = "/meldingJSON", method = RequestMethod.GET)
    public List<Melding> getAllMeldingenJson(Model model) {
        return mr.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/meldingJSON/findByLocatie/{locatie}", method = RequestMethod.GET)
    public List<Melding> findByLocatie(@PathVariable("locatie") String locatie) {
        return ms.getByLocatie(locatie);
    }

    @ResponseBody
    @RequestMapping(value = "/meldingJSON/deleteById/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable("id") String id) {
        ms.deleteById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/meldingJSON/findById/{id}", method = RequestMethod.GET)
    public Optional<Melding> findById(@PathVariable("id") String id) {
        return ms.getById(id);
    }

    // private final AtomicLong counter = new AtomicLong();

    // @RequestMapping(value = "/update/{a}", method = RequestMethod.POST)
    // public Melding meldingInsert(@RequestBody Melding m) {
    // return mr.save(new Melding(m.getId(), m.getReactie()));
    // }

    // @ResponseBody
    // @RequestMapping(value = "/meldingJSON/update", method = RequestMethod.GET)
    // public String update(@RequestBody Melding m) {
    // Melding melding = ms.updateMelding(m);
    // return melding.toString();
    // }

    // @ResponseBody
    // @RequestMapping(value = "meldingJSON/update/{id}", method =
    // RequestMethod.PATCH)
    // public Melding update(@PathVariable(value = "id") String id, @RequestBody
    // Melding myDocument) {
    // myDocument.setId(id);
    // return mr.save(myDocument);

    // }

}