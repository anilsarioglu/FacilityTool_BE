package edu.ap.facilitytoolspringboot.models;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "melding")
public class Melding {

    @Id
    private String id;

    private String melder;

    private String PNummer;

    private List<Binary> image;

    public Melding() {
        super();
        image = new ArrayList<>();
    }

    public Melding(Melding melding) {
        super();
    }

    public Melding(String melder, String PNummer) {
        // super();
        this.melder = melder;
        this.PNummer = PNummer;
    }

    public Melding(String melder) {
        super();
        this.melder = melder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMelder() {
        return melder;
    }

    public void setMelder(String melder) {
        this.melder = melder;
    }

    public List<Binary> getImage() {
        return this.image;
    }

    public void setImage(Binary img) {
        image.add(img);
    }

    public String getPNummer() {
        return this.PNummer;
    }

    public void setPNummer(String PNummer) {
        this.PNummer = PNummer;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", melder='" + getMelder() + "'" + ", PNummer='" + getPNummer() + "'"
                + ", image='" + getImage() + "'" + "}";
    }

}