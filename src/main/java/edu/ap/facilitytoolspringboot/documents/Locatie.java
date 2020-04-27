package edu.ap.facilitytoolspringboot.documents;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locatie")
public class Locatie {

    // @Id
    // private BigInteger Id;

    private String campus;
    private Integer verdieping;
    private String lokaal;
    private String naam;

    public Locatie() {
    }

    public Locatie(String campus, Integer verdieping, String lokaal, String naam) {
        this.campus = campus;
        this.verdieping = verdieping;
        this.lokaal = lokaal;
        this.naam = naam;
    }

    public String getCampus() {
        return this.campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public Integer getVerdieping() {
        return this.verdieping;
    }

    public void setVerdieping(Integer verdieping) {
        this.verdieping = verdieping;
    }

    public String getLokaal() {
        return this.lokaal;
    }

    public void setLokaal(String lokaal) {
        this.lokaal = lokaal;
    }

    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

}