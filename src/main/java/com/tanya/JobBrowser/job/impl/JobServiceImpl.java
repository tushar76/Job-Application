package com.tanya.JobBrowser.job.impl;

import com.tanya.JobBrowser.job.Job;
import com.tanya.JobBrowser.job.JobRepository;
import com.tanya.JobBrowser.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {

    //List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;


    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }




    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);

    }

    @Override
    public Job findById(long id) {
       return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJob(long id) {

        try
        {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public Boolean updateJob(long id, Job updatedjob) {

        Optional<Job> Opjob = jobRepository.findById(id);

            if(Opjob.isPresent())
            {
                Job job = Opjob.get();
                job.setDesc(updatedjob.getDesc());
                job.setLocation(updatedjob.getLocation());
                job.setTitle(updatedjob.getTitle());
                job.setLocation(updatedjob.getLocation());
                job.setMaxSalary(updatedjob.getMaxSalary());
                job.setMinSalary(updatedjob.getMinSalary());
                jobRepository.save(job);
                return true;
            }

        return false;
    }
}
