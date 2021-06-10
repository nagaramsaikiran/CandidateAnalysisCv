package com.capgemini.personality.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.personality.entity.Skill;
import com.capgemini.personality.exception.NotFoundException;
import com.capgemini.personality.model.SkillDTO;
import com.capgemini.personality.service.ISkillService;
/*@author name:Nagaram sai kiran
 * date:07/06/2021
 * Description:It processes the incoming requests regarding skills
 * Last modification date:09/06/2021
 */
@RestController
@RequestMapping("/service")
public class SkillController {
	@Autowired
	private ISkillService skillService;

	@RequestMapping("/getskills")
	public List<SkillDTO> getAllSkills() {
		List<SkillDTO> skills= skillService.getAllSkills();
		if(skills.isEmpty()) {
			throw new NotFoundException("No skills found");
		}
		return skills;
	}

	@RequestMapping("/getskill/{skillId}")
	public Optional<SkillDTO> getskill(@PathVariable("skillId") Integer id) {
		Optional<SkillDTO> skill= Optional.ofNullable(skillService.getSkill(id));
		if(!skill.isPresent()) {
			throw new NotFoundException("skill Id not found");
		}
		return skill;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addskill")
	public SkillDTO addskill(@RequestBody Skill skill) {
		return skillService.addSkill(skill);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateskill")
	public Skill updateskill(@RequestBody Skill skill) {
		Optional<SkillDTO> skill1= Optional.ofNullable(skillService.getSkill(skill.getSkillId()));
		if(!skill1.isPresent()) {
			throw new NotFoundException("Skill Id Not Found");
		}
		return skill;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteskill/{skillId}")
	public SkillDTO deleteskill(@PathVariable("skillId") Integer id) {
		Optional<SkillDTO> skill1= Optional.ofNullable(skillService.getSkill(id));
		if(!skill1.isPresent()) {
			throw new NotFoundException("Skill Id Not Found");
		}
		return skillService.deleteSkill(id);
	}

}
