package com.capgemini.personality.entity;

import java.util.List;

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
	@OneToMany
	@JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = { "candidate_candidate_id", "skills_skill_id" }))
	private List<Skill> skills;
	@ManyToMany
	private List<JobDetails> appliedJobs;
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

	public Candidate(String name, int candidateId, List<Skill> skills, int experience) {
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

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<JobDetails> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(List<JobDetails> appliedJobs) {
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
