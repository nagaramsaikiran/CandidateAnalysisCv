package com.capgemini.personality.model;

import java.util.List;

import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.entity.Skill;

public class JobDetailsDTO {
	private int jobId;
	private String role;
	private List<Skill> skills;
	private List<Candidate> appliedCandidates;
	private int experience;

	public JobDetailsDTO() {
		super();
	}

	public JobDetailsDTO(int jobId, String role, List<Skill> skills, int experience) {
		super();
		this.jobId = jobId;
		this.role = role;
		this.skills = skills;
		this.experience = experience;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
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
