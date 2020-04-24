package edu.ap.facilitytoolspringboot.services;

import java.io.IOException;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.ap.facilitytoolspringboot.documenten.Melding;
import edu.ap.facilitytoolspringboot.repositories.MeldingRepo;

@Service
public class MeldingServ {

    @Autowired
    private MeldingRepo mr;

    public Melding getMelding(String id) {
        return mr.findById(id).get();
    }

    public Melding addMeldingService(String melder, String PNummer, String datum, String type, String locatie,
            String beschrijving, String locatiebeschr) throws IOException {

        Melding melding = new Melding();
        melding.setMelder(melder);
        melding.setPNummer(PNummer);
        melding.setDatum(datum);
        melding.setType(type);
        melding.setLocatie(locatie);
        melding.setBeschrijving(beschrijving);
        melding.setLocatiebeschr(locatiebeschr);

        return mr.insert(melding);
    }

    // public Melding addMeldingService(String melder, String PNummer, String datum,
    // String type, String locatie,
    // String beschrijving, String locatiebeschr, MultipartFile[] file) throws
    // IOException {

    // Melding melding = new Melding();
    // melding.setMelder(melder);
    // melding.setPNummer(PNummer);
    // melding.setDatum(datum);
    // melding.setType(type);
    // melding.setLocatie(locatie);
    // melding.setBeschrijving(beschrijving);
    // melding.setLocatiebeschr(locatiebeschr);

    // for (MultipartFile f : file) {
    // melding.setImage(new Binary(BsonBinarySubType.BINARY, f.getBytes()));
    // }

    // return mr.insert(melding);
    // }

    public Melding create(Melding m) {
        return mr.save(new Melding(m));
    }

    public List<Melding> getAlleMeldingen() {
        return mr.findAll();
    }

    // public Melding getAlleImages(Binary image) {
    // return mr.findByImage(image);
    // }

    public Melding getMeldingM(String melder) {
        return mr.findByMelder(melder);
    }

    public void deleteAll() {
        mr.deleteAll();
    }

    public void delete(String melder) {
        Melding mm = mr.findByMelder(melder);
        mr.delete(mm);
    }
}