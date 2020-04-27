package edu.ap.facilitytoolspringboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.ap.facilitytoolspringboot.documents.Locatie;

@Repository
public interface LocatieRepo extends MongoRepository<Locatie, String> {

    public List<Locatie> findByCampus(String campus);

    public List<Locatie> findByVerdieping(Integer verdieping);

    public List<Locatie> findByLokaal(String lokaal);

    public List<Locatie> findByNaam(String naam);

}