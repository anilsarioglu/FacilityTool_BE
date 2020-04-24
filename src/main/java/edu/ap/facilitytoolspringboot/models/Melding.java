package edu.ap.facilitytoolspringboot.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "melding")
public class Melding {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId _id;

    private String melder;
    private String datum;
    private String type;
    private String locatie;
    private String beschrijving;
    private String locatiebeschr;
    private Object photos;

    public Melding() {
    }

    public Melding(Object photos) {
        this.photos = photos;
    }

    public Melding(String melder) {
        this.melder = melder;
    }

    public Melding(Melding melding) {
    }

    public Melding(String melder, String datum, String type, String locatie, String beschrijving,
                   String locatiebeschr) {
        this.melder = melder;
        this.datum = datum;
        this.type = type;
        this.locatie = locatie;
        this.beschrijving = beschrijving;
        this.locatiebeschr = locatiebeschr;
    }

    public Melding(ObjectId _id, String melder, String datum, String type, String locatie, String beschrijving,
                   String locatiebeschr, Object photos) {
        this._id = _id;
        this.melder = melder;
        this.datum = datum;
        this.type = type;
        this.locatie = locatie;
        this.beschrijving = beschrijving;
        this.locatiebeschr = locatiebeschr;
        this.photos = photos;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getMelder() {
        return melder;
    }

    public void setMelder(String melder) {
        this.melder = melder;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getLocatiebeschr() {
        return locatiebeschr;
    }

    public void setLocatiebeschr(String locatiebeschr) {
        this.locatiebeschr = locatiebeschr;
    }

    public Object getPhotos() {
        return photos;
    }

    public void setPhotos(Object photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Melding{" +
                "_id=" + _id +
                ", melder='" + melder + '\'' +
                ", datum='" + datum + '\'' +
                ", type='" + type + '\'' +
                ", locatie='" + locatie + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", locatiebeschr='" + locatiebeschr + '\'' +
                ", photos=" + photos +
                '}';
    }
}
