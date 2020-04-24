package edu.ap.facilitytoolspringboot.controllers;

import edu.ap.facilitytoolspringboot.models.Defect;
import edu.ap.facilitytoolspringboot.services.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DefectController {
    @Autowired
    private DefectService defectService;

    @RequestMapping(value = "/seed", method = RequestMethod.GET)
    public String seedData() {
        defectService.seedData();
        return "redirect:/defect";
    }

    @GetMapping
    public String index() {
        return "redirect:/defect";
    }

    @ResponseBody
    @RequestMapping(value = "/defect", method = RequestMethod.GET)
    public List<Defect> getAll() {
        return defectService.getAll();
    }

    @PutMapping("/defect/upvote/{id}")
    public ResponseEntity<Defect> toggleUpvote(@PathVariable("id") long id) {
        Object obj = defectService.toggleUpvote(id);
        if (obj != null) {
            System.out.println("\nAfter\n==================");
            System.out.println(obj);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
