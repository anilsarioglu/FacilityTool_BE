package edu.ap.facilitytoolspringboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.ap.facilitytoolspringboot.documents.Category;

@Repository
public interface CategoryRepo extends MongoRepository<Category, String> {

    public Category findByName(String name);
}