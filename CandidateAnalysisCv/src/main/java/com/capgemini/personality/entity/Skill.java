package com.capgemini.personality.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skill {

	private String skillName;
	@Id
	private int skillId;

	public Skill() {
		super();
	}

	public Skill(String skillName, int skillId) {
		super();
		this.skillName = skillName;
		this.skillId = skillId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int id) {
		this.skillId = id;
	}


	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
