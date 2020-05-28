package edu.ap.facilitytoolspringboot.models;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

import edu.ap.facilitytoolspringboot.models.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "melding")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String reporter;
    private String pNumber;
    private Date date;
    private String type;
    private Date requestDate;
    private String location;
    private String category;
    private String description;
    private String locationDescription;

    // Upvoting system
    private int numberUpvotes;
    private boolean isUpvoted;

    // @Enumerated(EnumType.STRING)
    private Status status;

    private List<Reaction> reactions;

    @Lob
    private Object photos;

    public Report() {
        
    }

    public Report(Object photos) {
        this.photos = photos;
    }

    public Report(String reporter) {
        super();
        this.reporter = reporter;
    }

    public Report(String reporter, String pNumber) {
        this.reporter = reporter;
        this.pNumber = pNumber;
    }

    public Report(String reporter, String pNumber, Date date, String type, Date requestDate, String location, String category, String description,
                  String locationDescription, Status status, Object photos) {
        this.reporter = reporter;
        this.pNumber = pNumber;
        this.date = date;
        this.type = type;
        this.requestDate = requestDate;
        this.location = location;
        this.category = category;
        this.requestDate = requestDate;
        this.description = description;
        this.locationDescription = locationDescription;
        this.status = status;
        this.photos = photos;
        // Upvoting system
        this.numberUpvotes = 0;
        this.isUpvoted = false;
    }

    public Report(String id, String reporter, String pNumber, Date date, Date requestDate, String type, String location, String category,
                  String description, String locationDescription) {
        this.id = id;
        this.reporter = reporter;
        this.pNumber = pNumber;
        this.date = date;
        this.type = type;
        this.requestDate = requestDate;
        this.location = location;
        this.category = category;
        this.requestDate = requestDate;
        this.description = description;
        this.locationDescription = locationDescription;
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

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getRequestDate(){
        return requestDate;
    }

    public void setRequestDate(Date requestDate){
        this.requestDate = requestDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    public Object getPhotos() {
        return photos;
    }

    public void setPhotos(Object photos) {
        this.photos = photos;
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

    public void setUpvoted(boolean isUpvoted) {
        this.isUpvoted = isUpvoted;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                ", reporter='" + reporter + '\'' +
                ", pNumber='" + pNumber + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", requestDate='" + requestDate + '\'' +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                ", numberUpvotes=" + numberUpvotes +
                ", isUpvoted=" + isUpvoted +
                ", status=" + status +
                ", reaction=" + reactions +
                ", photos=" + photos +
                '}';
    }
}
