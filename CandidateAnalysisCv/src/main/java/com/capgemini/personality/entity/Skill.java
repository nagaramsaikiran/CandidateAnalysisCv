package com.capgemini.personality.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*@author name:whole team
 * date:03/06/2021
 * Description:Skills description
 * Last modification date:09/06/2021
 */
@Entity
public class Skill {

	private String skillName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
