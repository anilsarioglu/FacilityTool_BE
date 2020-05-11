package edu.ap.facilitytoolspringboot.config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import edu.ap.facilitytoolspringboot.repositories.CategoryRepository;

@EnableMongoRepositories(basePackageClasses = CategoryRepository.class)
@Configuration
public class MongoDBConfigCategory {

}