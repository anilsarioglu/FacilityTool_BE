package edu.ap.facilitytoolspringboot.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.ap.facilitytoolspringboot.models.Melding;
import edu.ap.facilitytoolspringboot.repositories.MeldingRepository;
import edu.ap.facilitytoolspringboot.services.MeldingService;

@Controller
public class MeldingController {

    @Autowired
    private MeldingService ms;

    @Autowired
    private MeldingRepository mr;

    @ResponseBody
    @RequestMapping(value = "/meldingJSON", method = RequestMethod.GET)
    public List<Melding> getAllMeldingenJson(Model model) {
        return mr.findAll();
    }

    @GetMapping("/photos")
    public String getAllMeldingen(Model m) {
        Melding melding = new Melding();

        for (Binary b : melding.getImage()) {
            m.addAttribute("image", Base64.getEncoder().encodeToString(b.getData()));
        }
        m.addAttribute("meldingen", mr.findAll());
        return "photos";
    }

    @GetMapping("/photos/upload")
    public String uploadPhoto() {
        return "uploadPhoto";
    }

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("melder") String melder, @RequestParam("PNummer") String PNummer,
            @RequestParam("image") MultipartFile[] image, Model model) throws IOException {

        ms.addMeldingService(melder, PNummer, image);
        return "redirect:/photos";
    }

}