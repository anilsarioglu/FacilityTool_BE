package edu.ap.facilitytoolspringboot.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Base64.Encoder;

import org.bson.Document;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
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

import edu.ap.facilitytoolspringboot.documenten.Melding;
import edu.ap.facilitytoolspringboot.repositories.MeldingRepo;
import edu.ap.facilitytoolspringboot.services.MeldingServ;

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
        System.out.println(melding);
        return mr.save(melding);
    }

    @ResponseBody
    @RequestMapping(value = "/meldingJSON", method = RequestMethod.GET)
    public List<Melding> getAllMeldingenJson(Model model) {
        return mr.findAll();
    }

    // @ResponseBody
    // @PostMapping("/melding")
    // public String addPhoto(@RequestParam("melder") String melder,
    // @RequestParam("PNummer") String PNummer,
    // @RequestParam("datum") String datum, @RequestParam("type") String type,
    // @RequestParam("locatie") String locatie, @RequestParam("beschrijving") String
    // beschrijving,
    // @RequestParam("locatiebeschr") String locatiebeschr, Model model) throws
    // IOException {

    // ms.addMeldingService(melder, PNummer, datum, type, locatie, beschrijving,
    // locatiebeschr);
    // return "lijst";
    // }

    // @PostMapping("/melding")
    // public String addPhoto(@RequestParam("melder") String melder,
    // @RequestParam("PNummer") String PNummer,
    // @RequestParam("datum") String datum, @RequestParam("type") String type,
    // @RequestParam("locatie") String locatie, @RequestParam("beschrijving") String
    // beschrijving,
    // @RequestParam("locatiebeschr") String locatiebeschr, @RequestParam("image")
    // MultipartFile[] image,
    // Model model) throws IOException {

    // ms.addMeldingService(melder, PNummer, datum, type, locatie, beschrijving,
    // locatiebeschr, image);
    // return "lijst";
    // }

    // @PostMapping("/melding/add")
    // public String addPhoto(@RequestParam("melder") String melder,
    // @RequestParam("PNummer") String PNummer,
    // @RequestParam("datum") String datum, @RequestParam("type") String type,
    // @RequestParam("locatie") String locatie, @RequestParam("beschrijving") String
    // beschrijving,
    // @RequestParam("locatiebeschr") String locatiebeschr, @RequestParam("image")
    // MultipartFile[] image,
    // Model model) throws IOException {

    // ms.addMeldingService(melder, PNummer, datum, type, locatie, beschrijving,
    // locatiebeschr, image);
    // return "lijst";
    // }

    // // @GetMapping("/photos")
    // // public String getAllMeldingen(Model m) {
    // // Melding melding = new Melding();

    // // for (Binary b : melding.getImage()) {
    // // m.addAttribute("image", Base64.getEncoder().encodeToString(b.getData()));
    // // }
    // // m.addAttribute("meldingen", mr.findAll());
    // // return "photos";
    // // }

    // // @GetMapping("/melding/add")
    // // public String index() {
    // // // return "redirect:/melding/add";
    // // }

    // @GetMapping("/lijst")
    // public String getAllMeldingen(Model m) {
    // Melding melding = new Melding();
    // m.addAttribute("meldingen", mr.findAll());

    // return "lijst";

    // // mr.findAll().forEach((melding) -> {
    // // for (Binary b : melding.getImage()) {
    // // String encoder = Base64.getEncoder().encodeToString(b.getData());
    // // m.addAttribute("images", encoder);
    // // System.out.println(encoder);
    // // }
    // // });

    // // String base64EncodedImage = Base64.encodeBase64String(foto);
    // // m.addAttribute("meldingen", mr.findAll());
    // // String originalInput = "test input";
    // // String encodedString =
    // // Base64.getEncoder().encodeToString(originalInput.getBytes());

    // // byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
    // // String decodedString = new String(decodedBytes);
    // // System.out.println(decodedString);

    // // for (Binary b : melding.getImage()) {
    // // m.addAttribute("images", Base64.getEncoder().encodeToString(b.getData()));

    // // }

    // // Melding melding = new Melding();

    // }

    // // @GetMapping("/photos/upload")
    // // public String uploadPhoto() {
    // // return "melding";
    // // }

    // @ResponseBody
    // @RequestMapping(value = "/meldingJSON", method = RequestMethod.GET)
    // public List<Melding> getAllMeldingenJson(Model model) {
    // return mr.findAll();
    // }

    // @PostMapping("/melding/add")
    // public String addPhoto(@RequestParam("melder") String melder,
    // @RequestParam("PNummer") String PNummer,
    // @RequestParam("datum") String datum, @RequestParam("type") String type,
    // @RequestParam("locatie") String locatie, @RequestParam("beschrijving") String
    // beschrijving,
    // @RequestParam("locatiebeschr") String locatiebeschr, @RequestParam("image")
    // MultipartFile[] image,
    // Model model) throws IOException {

    // ms.addMeldingService(melder, PNummer, datum, type, locatie, beschrijving,
    // locatiebeschr, image);
    // return "lijst";
    // }

    // // @GetMapping("/photos")
    // // public String getAllMeldingen(Model m) {
    // // Melding melding = new Melding();

    // // for (Binary b : melding.getImage()) {
    // // m.addAttribute("image", Base64.getEncoder().encodeToString(b.getData()));
    // // }
    // // m.addAttribute("meldingen", mr.findAll());
    // // return "photos";
    // // }

}