package edu.ap.facilitytoolspringboot.repositories;

import edu.ap.facilitytoolspringboot.models.Defect;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DefectRepository extends MongoRepository<Defect, Long> {
}
