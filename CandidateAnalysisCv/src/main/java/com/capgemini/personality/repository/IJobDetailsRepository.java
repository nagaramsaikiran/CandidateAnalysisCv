package com.capgemini.personality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.personality.entity.JobDetails;
@Repository
public interface IJobDetailsRepository extends JpaRepository<JobDetails, Integer> {

}
