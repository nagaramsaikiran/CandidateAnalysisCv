package com.capgemini.personality.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Table;
/*@author name:whole team
 * date:03/06/2021
 * Description:Job Details description
 * Last modification date:09/06/2021
 */
@Entity
@Table(name = "JobDetails")
public class JobDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobId;
	private String role;
	@ManyToMany
	private Set<Skill> skills;
	@ManyToMany(mappedBy = "appliedJobs")
	private Set<Candidate> appliedCandidates;
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

	public JobDetails(int jobId, String role, Set<Skill> skills, int experience) {
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

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	@JsonIgnore
	public Set<Candidate> getAppliedCandidates() {
		return appliedCandidates;
	}

	public void setAppliedCandidates(Set<Candidate> appliedCandidates) {
		this.appliedCandidates = appliedCandidates;
	}

}
