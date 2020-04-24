package edu.ap.facilitytoolspringboot.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection = "defect")
public class Defect {
    @Id
    private long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String title;
    private int numberUpvotes;
    private boolean isUpvoted;

    public Defect() {
    }

    public Defect(long id, String title, int numberUpvotes) {
        this.id = id;
        this.title = title;
        this.numberUpvotes = numberUpvotes;
        this.isUpvoted = false;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

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
        return "Defect{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberUpvotes=" + numberUpvotes +
                ", isUpvoted=" + isUpvoted +
                '}';
    }
}
