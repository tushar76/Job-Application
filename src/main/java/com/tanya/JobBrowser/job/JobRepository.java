package com.tanya.JobBrowser.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// crudRepositiory use when u need to built basic curd op
// JpaRepositiory use to get extra op with curd repo
@Repository
public interface JobRepository extends JpaRepository<Job ,Long> {
    // long ->datatype of primary key
}
