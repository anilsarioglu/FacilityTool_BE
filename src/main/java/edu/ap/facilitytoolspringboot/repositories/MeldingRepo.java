package edu.ap.facilitytoolspringboot.repositories;

import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.ap.facilitytoolspringboot.documenten.Melding;

public interface MeldingRepo extends MongoRepository<Melding, String> {
    public Melding findByMelder(String melder);

    // public Melding findByImage(Binary image);
}