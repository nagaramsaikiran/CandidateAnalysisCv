package com.capgemini.personality.model;

import javax.persistence.Id;

public class SkillDTO {
	private String skillName;
	private int skillId;
	public SkillDTO() {
		super();
	}
	public SkillDTO(String skillName, int skillId) {
		super();
		this.skillName = skillName;
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

}
