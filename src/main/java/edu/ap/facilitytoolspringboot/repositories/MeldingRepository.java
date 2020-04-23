package edu.ap.facilitytoolspringboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.ap.facilitytoolspringboot.models.Melding;

public interface MeldingRepository extends MongoRepository<Melding, String> {

}