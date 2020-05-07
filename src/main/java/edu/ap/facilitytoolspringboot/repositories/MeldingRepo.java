package edu.ap.facilitytoolspringboot.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.ap.facilitytoolspringboot.documents.Melding;

@Repository
public interface MeldingRepo extends MongoRepository<Melding, String> {

    public Melding findByMelder(String melder);

    public List<Melding> findByLocatie(String locatie);

    public List<Melding> findByCategory(String category);

    // public Melding save(Optional<Melding> m);

    // public Melding findByImage(Binary image);
}