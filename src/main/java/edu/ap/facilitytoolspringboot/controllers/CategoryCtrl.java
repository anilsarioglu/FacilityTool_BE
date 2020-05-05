package edu.ap.facilitytoolspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.ap.facilitytoolspringboot.documents.Category;
import edu.ap.facilitytoolspringboot.repositories.CategoryRepo;
import edu.ap.facilitytoolspringboot.services.CategoryServ;

@RestController
// @Controller

@CrossOrigin
public class CategoryCtrl {

    @Autowired
    private CategoryServ csrv;

    @Autowired
    private CategoryRepo cr;

    @GetMapping("/getAllCategories")
    public List<Category> getAll() {
        return cr.findAll();
    }

    @PostMapping(value = "/addCategory")
    public void postMelding(@RequestBody Category category) {
        cr.save(category);
    }

    @ResponseBody
    @RequestMapping(value = "/category/deleteByName/{name}", method = RequestMethod.GET)
    public void deleteByNameParam(@PathVariable("name") String name) {
        csrv.deleteByName(name);
    }
}