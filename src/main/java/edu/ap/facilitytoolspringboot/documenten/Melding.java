package edu.ap.facilitytoolspringboot.documenten;

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
    private String datum;
    private String type;
    private String locatie;
    private String beschrijving;
    private String locatiebeschr;
    // private Status status;

    // private List<Binary> image;

    // public Melding() {
    // super();
    // image = new ArrayList<>();
    // }

    public Melding(Melding melding) {
        super();
    }

    public Melding() {
        super();
    }

    public Melding(String melder) {
        super();
        this.melder = melder;
    }

    public Melding(String melder, String PNummer) {
        this.melder = melder;
        this.PNummer = PNummer;
    }

    public Melding(String melder, String PNummer, String datum, String type, String locatie, String beschrijving,
            String locatiebeschr) {
        this.melder = melder;
        this.PNummer = PNummer;
        this.datum = datum;
        this.type = type;
        this.locatie = locatie;
        this.beschrijving = beschrijving;
        this.locatiebeschr = locatiebeschr;
    }

    public Melding(String id, String melder, String PNummer, String datum, String type, String locatie,
            String beschrijving, String locatiebeschr) {
        this.id = id;
        this.melder = melder;
        this.PNummer = PNummer;
        this.datum = datum;
        this.type = type;
        this.locatie = locatie;
        this.beschrijving = beschrijving;
        this.locatiebeschr = locatiebeschr;
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

    // public List<Binary> getImage() {
    // return this.image;
    // }

    // public void setImage(Binary img) {
    // image.add(img);
    // }

    public String getPNummer() {
        return this.PNummer;
    }

    public void setPNummer(String PNummer) {
        this.PNummer = PNummer;
    }

    public String getDatum() {
        return this.datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocatie() {
        return this.locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getBeschrijving() {
        return this.beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getLocatiebeschr() {
        return this.locatiebeschr;
    }

    public void setLocatiebeschr(String locatiebeschr) {
        this.locatiebeschr = locatiebeschr;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", melder='" + getMelder() + "'" + ", PNummer='" + getPNummer() + "'"
                + ", datum='" + getDatum() + "'" + ", type='" + getType() + "'" + ", locatie='" + getLocatie() + "'"
                + ", beschrijving='" + getBeschrijving() + "'" + ", locatiebeschr='" + getLocatiebeschr() + "'" + "}";
    }

}