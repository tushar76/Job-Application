package com.tanya.JobBrowser.job;


import com.tanya.JobBrowser.company.Company;
import jakarta.persistence.*;

@Entity
// by dafualt table name is class name
//@Table(name = "job_table")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String desc;
    private String minSalary ;
    private String maxSalary ;
    private String location ;

    @ManyToOne
    private Company company;



    // need default constructor when u work at JPA
    public Job()
    {

    }
    public Job(String location, String maxSalary, String minSalary, String desc, String title, long id) {
        this.location = location;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.desc = desc;
        this.title = title;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
