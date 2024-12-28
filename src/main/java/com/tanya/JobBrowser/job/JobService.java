package com.tanya.JobBrowser.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);

    Job findById(long id);

    Boolean deleteJob(long id);

    Boolean updateJob(long id, Job updatedjob);
}
