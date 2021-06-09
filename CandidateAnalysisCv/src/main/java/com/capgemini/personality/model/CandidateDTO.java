package com.capgemini.personality.model;

import java.util.List;

import com.capgemini.personality.entity.Gender;
import com.capgemini.personality.entity.JobDetails;
import com.capgemini.personality.entity.Skill;

public class CandidateDTO {

	private String name;
	private int candidateId;
	private String mobileNum;
	private String emailId;
	private Gender gender;
	private List<Skill> skills;
	private List<JobDetails> jobDetails;
	private int experience;

	public CandidateDTO() {
		super();
	}

	public CandidateDTO(String name, int candidateId, List<Skill> skills, int experience) {
		super();
		this.name = name;
		this.candidateId = candidateId;
		this.skills = skills;
		this.experience = experience;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
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

	public List<JobDetails> getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(List<JobDetails> jobDetails) {
		this.jobDetails = jobDetails;
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
