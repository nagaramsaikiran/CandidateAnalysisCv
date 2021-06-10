package com.capgemini.personality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.personality.entity.Skill;
import com.capgemini.personality.model.SkillDTO;
import com.capgemini.personality.repository.ISkillRepository;
import com.capgemini.personality.utils.SkillUtil;
/*@author name:Nagaram Sai kiran
 * date:05/06/2021
 * Description:SkillService description
 * Last modification date:09/06/2021
 */
@Service
public class SkillServiceImpl  implements ISkillService{
@Autowired
ISkillRepository skillRepo;
@Autowired
SkillUtil su;
	@Override
	public SkillDTO getSkill(int id) {
		Skill skill=skillRepo.getById(id);
		return su.convertToSkillDto(skill);
	}

	@Override
	public List<SkillDTO> getAllSkills() {
		List<Skill> list=skillRepo.findAll();
		return su.convertToSkillDtoList(list);
	}

	@Override
	public SkillDTO addSkill(Skill skill) {
		skillRepo.save(skill);
		return su.convertToSkillDto(skill);
	}

	@Override
	public SkillDTO updateSkill(Skill skill) {
		skillRepo.saveAndFlush(skill);
		return su.convertToSkillDto(skill);
	}

	@Override
	public SkillDTO deleteSkill(int id) {
		Skill skill=skillRepo.getById(id);
		skillRepo.deleteById(id);
		return su.convertToSkillDto(skill);
	}

}
