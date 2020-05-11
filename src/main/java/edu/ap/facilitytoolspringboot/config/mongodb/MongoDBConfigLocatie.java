package edu.ap.facilitytoolspringboot.config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import edu.ap.facilitytoolspringboot.repositories.LocationRepository;

@EnableMongoRepositories(basePackageClasses = LocationRepository.class)
@Configuration
public class MongoDBConfigLocatie {

}