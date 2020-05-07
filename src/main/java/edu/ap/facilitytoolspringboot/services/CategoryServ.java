package edu.ap.facilitytoolspringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.facilitytoolspringboot.documents.Category;
import edu.ap.facilitytoolspringboot.repositories.CategoryRepo;

@Service
public class CategoryServ {

    @Autowired
    private CategoryRepo cr;

    public Category create(String name, String description) {
        return cr.save(new Category(name, description));
    }

    public List<Category> getAll() {
        return cr.findAll();
    }

    public void deleteByName(String name) {
        Category c = cr.findByName(name);
        cr.delete(c);
    }
}