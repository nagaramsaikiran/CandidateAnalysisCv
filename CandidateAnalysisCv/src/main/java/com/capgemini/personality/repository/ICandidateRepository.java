package com.capgemini.personality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.personality.entity.Candidate;

/*@author name:Akhil and Rajitha
 * date:05/06/2021
 * Description:Creating candidate repository to perform crud operations and location for storing Modules
 * Last modification date:09/06/2021
 */
@Repository
public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {

}
