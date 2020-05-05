package edu.ap.facilitytoolspringboot.config.mongodb;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {
    private MongoProperties locatie = new MongoProperties();
    private MongoProperties melding = new MongoProperties();
    private MongoProperties category = new MongoProperties();

    public MultipleMongoProperties() {
    }

    public MultipleMongoProperties(MongoProperties location, MongoProperties melding, MongoProperties category) {
        this.locatie = location;
        this.melding = melding;
        this.category = category;
    }

    public MongoProperties getLocation() {
        return this.locatie;
    }

    public void setLocation(MongoProperties location) {
        this.locatie = location;
    }

    public MongoProperties getMelding() {
        return this.melding;
    }

    public void setMelding(MongoProperties melding) {
        this.melding = melding;
    }

    public MongoProperties getCategory() {
        return this.category;
    }

    public void setCategory(MongoProperties category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "{" + " locatie='" + getLocation() + "'" + ", melding='" + getMelding() + "'" + ", category='" + getCategory() +  "}";
    }

}