package com.capgemini.personality.service;

import java.util.List;

import com.capgemini.personality.entity.Skill;
import com.capgemini.personality.model.SkillDTO;

public interface ISkillService {
public SkillDTO getSkill(int id);
	
	public List<SkillDTO> getAllSkills();

	public SkillDTO addSkill(Skill Skill);

	public SkillDTO updateSkill(Skill Skill);

	public SkillDTO deleteSkill(int id);


}
