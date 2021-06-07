package com.capgemini.personality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.personality.entity.Candidate;
@Repository
public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {

}
