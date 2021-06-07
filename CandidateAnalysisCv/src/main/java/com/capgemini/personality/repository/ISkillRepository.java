package com.capgemini.personality.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.personality.entity.Skill;
@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer> {

}