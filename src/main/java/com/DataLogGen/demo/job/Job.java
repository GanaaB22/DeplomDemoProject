package com.DataLogGen.demo.job;

import com.DataLogGen.demo.companies.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title ;
    private String description;
    private String minSalory;
    private String maxSalory;
    private String location;

    @ManyToOne
    @JsonIgnore
    private Company company;


    public Job() {
    }

    public Job(Long id, String title, String description, String minSalory, String maxSalory, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalory = minSalory;
        this.maxSalory = maxSalory;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalory() {
        return minSalory;
    }

    public void setMinSalory(String minSalory) {
        this.minSalory = minSalory;
    }

    public String getMaxSalory() {
        return maxSalory;
    }

    public void setMaxSalory(String maxSalory) {
        this.maxSalory = maxSalory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
