package edu.ap.facilitytoolspringboot.config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import edu.ap.facilitytoolspringboot.repositories.CategoryRepo;

@EnableMongoRepositories(basePackageClasses = CategoryRepo.class)
@Configuration
public class MongoDBConfigCategory {

}