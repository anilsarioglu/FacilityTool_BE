package edu.ap.facilitytoolspringboot.services;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.ap.facilitytoolspringboot.models.Melding;
import edu.ap.facilitytoolspringboot.repositories.MeldingRepository;

@Service
public class MeldingService {

    @Autowired
    private MeldingRepository mr;

    public Melding getMelding(String id) {
        return mr.findById(id).get();
    }

    public Melding addMeldingService(String melder, String PNummer, MultipartFile[] file) throws IOException {

        Melding melding = new Melding();
        melding.setMelder(melder);
        melding.setPNummer(PNummer);

        for (MultipartFile f : file) {
            melding.setImage(new Binary(BsonBinarySubType.BINARY, f.getBytes()));
        }

        return mr.insert(melding);
    }
}