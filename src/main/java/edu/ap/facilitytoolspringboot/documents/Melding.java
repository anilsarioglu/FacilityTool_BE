package edu.ap.facilitytoolspringboot.documents;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

import org.bson.types.Binary;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.ap.facilitytoolspringboot.models.Status;

@Document(collection = "melding")

public class Melding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String melder;
    private String pNummer;
    private String datum;
    private String type;
    private String locatie;
    private String beschrijving;
    private String locatiebeschr;

    // @Enumerated(EnumType.STRING)
    private Status status;

    private List<Reactie> reactie;

    @Lob
    private Object photos;

    public Melding(Melding melding) {
        super();
    }

    public Melding() {
        super();
    }

    public Melding(Object photos) {
        this.photos = photos;
    }

    public Melding(String melder) {
        super();
        this.melder = melder;
    }

    public Melding(String melder, String pNummer) {
        this.melder = melder;
        this.pNummer = pNummer;
    }

    public Melding(String melder, String pNummer, String datum, String type, String locatie, String beschrijving,
            String locatiebeschr, Status status, Object photos) {
        this.melder = melder;
        this.pNummer = pNummer;
        this.datum = datum;
        this.type = type;
        this.locatie = locatie;
        this.beschrijving = beschrijving;
        this.locatiebeschr = locatiebeschr;
        this.status = status;
        this.photos = photos;
    }

    public Melding(String id, String melder, String pNummer, String datum, String type, String locatie,
            String beschrijving, String locatiebeschr) {
        this.id = id;
        this.melder = melder;
        this.pNummer = pNummer;
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

    public String getpNummer() {
        return this.pNummer;
    }

    public void setpNummer(String pNummer) {
        this.pNummer = pNummer;
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

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getPhotos() {
        return this.photos;
    }

    public void setPhotos(Object photos) {
        this.photos = photos;
    }

    public String getPNummer() {
        return this.pNummer;
    }

    public void setPNummer(String pNummer) {
        this.pNummer = pNummer;
    }

    public List<Reactie> getReactie() {
        return this.reactie;
    }

    public void setReactie(List<Reactie> reactie) {
        this.reactie = reactie;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", melder='" + getMelder() + "'" + ", pNummer='" + getPNummer() + "'"
                + ", datum='" + getDatum() + "'" + ", type='" + getType() + "'" + ", locatie='" + getLocatie() + "'"
                + ", beschrijving='" + getBeschrijving() + "'" + ", locatiebeschr='" + getLocatiebeschr() + "'"
                + ", status='" + getStatus() + "'" + ", reactie='" + getReactie() + "'" + ", photos='" + getPhotos()
                + "'" + "}";
    }

}