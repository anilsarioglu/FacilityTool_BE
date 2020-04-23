package edu.ap.facilitytoolspringboot.Models;

import javax.persistence.*;

@Entity
public class Defect {
    @Id
    private long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private String title;

    private int numberUpvote;

    public Defect() {
    }

    public Defect(String title) {
        this.title = title;
        this.numberUpvote = 2;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberUpvote() {
        return numberUpvote;
    }

    @Override
    public String toString() {
        return "Defect{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberUpvote=" + numberUpvote +
                '}';
    }
}
