package com.capgemini.personality.model;
/*@author name:whole team
 * date:04/06/2021
 * Description:SkillDTO description
 * Last modification date:09/06/2021
 */
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
