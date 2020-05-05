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

    public Category create(String name, String type) {
        return cr.save(new Category(name, type));
    }

    public List<Category> getAll() {
        return cr.findAll();
    }

    public List<Category> getByName(String name) {
        return cr.findByName(name);
    }

    public List<Category> getByType(String type) {
        return cr.findByType(type);
    }

}