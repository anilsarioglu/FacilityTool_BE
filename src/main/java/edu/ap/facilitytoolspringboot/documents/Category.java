package edu.ap.facilitytoolspringboot.documents;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
public class Category {

    private String name;
    private String type;
 

    public Category() {
    }

    public Category(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}