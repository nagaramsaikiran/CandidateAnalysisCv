package com.capgemini.personality.model;

import java.util.List;
import java.util.Set;

import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.entity.Skill;
/*@author name:whole team
 * date:04/06/2021
 * Description:JobDetailsDTO description
 * Last modification date:09/06/2021
 */

public class JobDetailsDTO {
	private int jobId;
	private String role;
	private Set<Skill> skills;
	private Set<Candidate> appliedCandidates;
	private int experience;

	public JobDetailsDTO() {
		super();
	}

	public JobDetailsDTO(int jobId, String role, Set<Skill> skills, int experience) {
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

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Set<Candidate> getAppliedCandidates() {
		return appliedCandidates;
	}

	public void setAppliedCandidates(Set<Candidate> appliedCandidates) {
		this.appliedCandidates = appliedCandidates;
	}
	

}
