package com.tanya.JobBrowser.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tanya.JobBrowser.company.Company;
import jakarta.persistence.*;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc;
    private String title;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Reviews() {
    }

    public Reviews(Long id, String desc, String title, double rating) {
        this.id = id;
        this.desc = desc;
        this.title = title;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
