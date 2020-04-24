package edu.ap.facilitytoolspringboot.repositories;

import edu.ap.facilitytoolspringboot.models.Melding;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeldingRepository extends MongoRepository<Melding, Integer> {
    public Melding findByMelder(String melder);
}
