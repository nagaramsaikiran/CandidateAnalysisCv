package com.capgemini.personality.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JobDetails")
public class JobDetails {
	@Id
	private int jobId;
	private String role;
	@OneToMany
	private List<Skill> skills;
	@ManyToMany
	private List<Candidate> appliedCandidates;
	private int experience;
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public JobDetails() {
		super();
	}

	public JobDetails(int jobId, String role, List<Skill> skills, int experience) {
		super();
		this.jobId = jobId;
		this.role = role;
		this.skills = skills;
		this.experience = experience;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public List<Candidate> getAppliedCandidates() {
		return appliedCandidates;
	}

	public void setAppliedCandidates(List<Candidate> appliedCandidates) {
		this.appliedCandidates = appliedCandidates;
	}
	

}
