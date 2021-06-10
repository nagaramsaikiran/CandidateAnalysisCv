package com.capgemini.personality.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*@author name:whole team
 * date:03/06/2021
 * Description:Candidate description
 * 
 */
@Entity
@Table(name = "CandidateDetails")
public class Candidate {
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int candidateId;
	@Column(nullable=false,unique=true)
	private String mobileNum;
	@Column(nullable=false,unique=true)
	private String emailId;
	private Gender gender;
	@ManyToMany
	private Set<Skill> skills;
	@ManyToMany
	private Set<JobDetails> appliedJobs;
	private int experience;

	public Candidate() {
		super();
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public Candidate(String name, int candidateId, Set<Skill> skills, int experience) {
		super();
		this.name = name;
		this.candidateId = candidateId;
		this.skills = skills;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
    
	@JsonIgnore
	public Set<JobDetails> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(Set<JobDetails> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
