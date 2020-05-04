package edu.ap.facilitytoolspringboot.documents;

import java.util.Date;

public class Reactie {

    private String messageId;
    private String name;
    private String message;
    private Date datum;

    public Reactie() {
    }

    public Reactie(String messageId, String name, String message, Date datum) {
        this.messageId = messageId;
        this.name = name;
        this.message = message;
        this.datum = datum;
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

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Date getDatum() {
        return this.datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "{" + " messageId='" + getMessageId() + "'" + ", name='" + getName() + "'" + ", message='" + getMessage()
                + "'" + ", datum='" + getDatum() + "'" + "}";
    }

}