package com.capgemini.personality.entity;



import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CandidateDetails")
public class Candidate {
	private String name;
	@Id
	private int candidateId;
	@OneToMany
	private List<Skill> skills;
	@ManyToMany(mappedBy = "appliedCandidates")
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

}
