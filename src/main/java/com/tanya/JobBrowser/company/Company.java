package com.tanya.JobBrowser.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tanya.JobBrowser.job.Job;
import com.tanya.JobBrowser.reviews.Reviews;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String desc;


    @JsonIgnore // ignore recursion callbacks and don't stuck into infinte loop
    //mapping for jobs
    @OneToMany(mappedBy = "company") // this tell this filed is mapped by job field name comapny
    private List<Job>jobs;


    //mapping for reviews
    @OneToMany(mappedBy = "company")
    private  List<Reviews> reviews;

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public Company() {
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
