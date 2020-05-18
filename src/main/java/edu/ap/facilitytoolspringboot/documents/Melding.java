package edu.ap.facilitytoolspringboot.documents;

import java.util.ArrayList;
import java.util.Date;
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
    private Date datum;
    private String type;
    private String locatie;
    private String category;
    private Date requestDate;
    private String beschrijving;
    private String locatiebeschr;
    // Upvoting system
    private int numberUpvotes;
    private boolean isUpvoted;

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

    public Melding(String melder, String pNummer, Date datum, String type, String locatie, String category, String beschrijving,
            String locatiebeschr, Status status, Object photos) {
        this.melder = melder;
        this.pNummer = pNummer;
        this.datum = datum;
        this.type = type;
        this.locatie = locatie;
        this.category = category;
        this.beschrijving = beschrijving;
        this.locatiebeschr = locatiebeschr;
        this.status = status;
        this.photos = photos;
        // Upvoting system
        this.numberUpvotes = 0;
        this.isUpvoted = false;
    }

    //Create task with pictures
    public Melding(String melder, String pNummer, Date datum, String type, String locatie, String category, Date requestDate, String beschrijving,
    String locatiebeschr, Status status, Object photos) {
        this.melder = melder;
        this.pNummer = pNummer;
        this.datum = datum;
        this.type = type;
        this.locatie = locatie;
        this.category = category;
        this.requestDate = requestDate;
        this.beschrijving = beschrijving;
        this.locatiebeschr = locatiebeschr;
        this.status = status;
        this.photos = photos;
        // Upvoting system
        this.numberUpvotes = 0;
        this.isUpvoted = false;
    }

    public Melding(String id, String melder, String pNummer, Date datum, String type, String locatie, String category,
            String beschrijving, String locatiebeschr) {
        this.id = id;
        this.melder = melder;
        this.pNummer = pNummer;
        this.datum = datum;
        this.type = type;
        this.locatie = locatie;
        this.category = category;
        this.beschrijving = beschrijving;
        this.locatiebeschr = locatiebeschr;
        // Upvoting system
        this.numberUpvotes = 0;
        this.isUpvoted = false;
    }

    //Create task without pictures
    public Melding(String id, String melder, String pNummer, Date datum, String type, String locatie, String category, Date requestDate,
    String beschrijving, String locatiebeschr) {
        this.id = id;
        this.melder = melder;
        this.pNummer = pNummer;
        this.datum = datum;
        this.type = type;
        this.locatie = locatie;
        this.category = category;
        this.requestDate = requestDate;
        this.beschrijving = beschrijving;
        this.locatiebeschr = locatiebeschr;
        // Upvoting system
        this.numberUpvotes = 0;
        this.isUpvoted = false;
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

    public Date getDatum() {
        return this.datum;
    }

    public void setDatum(Date datum) {
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

    public String getCatgeory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getRequestDate() {
        return this.requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
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

    // Upvoting system
    public int getNumberUpvotes() {
        return numberUpvotes;
    }

    public void setNumberUpvotes(int numberUpvotes) {
        this.numberUpvotes = numberUpvotes;
    }

    public boolean isUpvoted() {
        return isUpvoted;
    }

    public void setUpvoted(boolean upvoted) {
        isUpvoted = upvoted;
    }

    @Override
    public String toString() {
        return "Melding{" +
                "id='" + id + '\'' +
                ", melder='" + melder + '\'' +
                ", pNummer='" + pNummer + '\'' +
                ", datum=" + datum +
                ", type='" + type + '\'' +
                ", locatie='" + locatie + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", locatiebeschr='" + locatiebeschr + '\'' +
                ", numberUpvotes=" + numberUpvotes +
                ", isUpvoted=" + isUpvoted +
                ", status=" + status +
                ", reactie=" + reactie +
                ", photos=" + photos +
                '}';
    }
}