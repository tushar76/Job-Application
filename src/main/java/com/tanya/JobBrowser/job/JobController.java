package com.tanya.JobBrowser.job;

import com.tanya.JobBrowser.job.impl.JobServiceImpl;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/jobs")  //act as a base URL
public class JobController {
    JobService jobservice ;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping("/")
    public ResponseEntity<List<Job>> findAll()
    {
        List<Job> jobs = jobservice.findAll();
        return new ResponseEntity<>(jobs,HttpStatus.FOUND) ;
    }

    @PostMapping("/")
    public ResponseEntity<String> createJob(@RequestBody Job job)
    {
        jobservice.createJob(job);
        return new ResponseEntity<>("Added Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable long id)
    {
       Job job=  jobservice.findById(id);
       if(job!=null)
       {
           return new ResponseEntity<>(job, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable long id)
    {
        Boolean jobDelete = jobservice.deleteJob(id);
        if(jobDelete)
        {
            return new ResponseEntity<>("Deleted Succefully" ,HttpStatus.OK);
        }
        return  new ResponseEntity<>("Not Found Job !", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    //@RequestMapping(value = "/jobs/{id}" ,method = RequestMethod.PUT)
    public ResponseEntity<String> UpdateJob(@PathVariable long id , @RequestBody Job Updatedjob)
    {
        Boolean updates = jobservice.updateJob(id,Updatedjob);

        if(updates)
        {
            return new ResponseEntity<>("Updated Succefully" ,HttpStatus.OK);
        }
        return  new ResponseEntity<>("Not Found Job !", HttpStatus.NOT_FOUND);
    }
}
