package edu.ap.facilitytoolspringboot.controllers;

import edu.ap.facilitytoolspringboot.models.Melding;
import edu.ap.facilitytoolspringboot.services.MeldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/melding")
public class MeldingController {
    @Autowired
    private MeldingService meldingService;

    @GetMapping()
    public String getAlleMeldingen(Model m) {
        m.addAttribute("meldingen", meldingService.getAlleMeldingen());
        List<Melding> mm = meldingService.getAlleMeldingen();
        return "Hele lijst";
    }

    @GetMapping("/meldingen")
    public String getDefect(Model m) {
        m.addAttribute("meldingen", meldingService.getAlleMeldingen());
        List<Melding> mm = meldingService.getAlleMeldingen();
        return "topper wee";
    }

}
