package edu.ap.facilitytoolspringboot.Controllers;

import edu.ap.facilitytoolspringboot.Models.Defect;
import edu.ap.facilitytoolspringboot.Repositories.DefectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DefectController {
    @Autowired
    private DefectRepository defectRepo;

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/addForm")
    public String getAddForm(Model model) {
        model.addAttribute("defect", new Defect());
        return "addForm";
    }

    @PostMapping("/addForm")
    public String defectSubmit(@ModelAttribute Defect defect) {
        return "result";
    }
}
