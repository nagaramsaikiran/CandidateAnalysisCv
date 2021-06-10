package com.capgemini.personality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.personality.entity.JobDetails;
/*@author name:Aravind
 * date:05/06/2021
 * Description:Creating JobDetails repository to perform crud operationsand location for storing Modules
 * Last modification date:09/06/2021
 */
@Repository
public interface IJobDetailsRepository extends JpaRepository<JobDetails, Integer> {

}
