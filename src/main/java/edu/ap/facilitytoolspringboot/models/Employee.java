package edu.ap.facilitytoolspringboot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String pNumber;
    private List<Report> assignedReports;

    public Employee() {
        assignedReports = new ArrayList<>();
    }

    public Employee(String name, String pNumber) {
        this.name = name;
        this.pNumber = pNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPNumber() {
        return pNumber;
    }

    public void setPNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public List<Report> getAssignedReports() {
        return assignedReports;
    }

    public void setAssignedReports(List<Report> assignedReports) {
        this.assignedReports = assignedReports;
    }

    public void addAssignedReport(Report assignedReport) {
        this.assignedReports.add(assignedReport);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pNumber='" + pNumber + '\'' +
                ", assignedReports=" + assignedReports +
                '}';
    }
}
