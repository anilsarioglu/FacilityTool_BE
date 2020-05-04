package edu.ap.facilitytoolspringboot.documents;

import javax.persistence.Id;

public class Reactie {

    // beter een 'messageId van maken'
    private String id;
    private String name;
    private String message;

    public Reactie() {
    }

    public Reactie(String id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", message='" + getMessage() + "'" + "}";
    }

}