package com.capgemini.personality.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capgemini.personality.entity.Skill;
import com.capgemini.personality.model.SkillDTO;
@Component
public class SkillUtil {
	public static List<SkillDTO> convertToSkillDtoList(List<Skill> list) {
		List<SkillDTO> dtolist = new ArrayList<>();
		for (Skill Skill : list)
			dtolist.add(convertToSkillDto(Skill));
		return dtolist;
	}

	public static Skill convertToSkill(SkillDTO SkillDTO) {
		Skill Skill = new Skill();
		Skill.setSkillName(SkillDTO.getSkillName());
		Skill.setSkillId(SkillDTO.getSkillId());
		return Skill;
	}

	public static SkillDTO convertToSkillDto(Skill Skill) {
		SkillDTO SkillDTO = new SkillDTO();
		SkillDTO.setSkillName(Skill.getSkillName());
		SkillDTO.setSkillId(Skill.getSkillId());
	
		return SkillDTO;
	}

}
