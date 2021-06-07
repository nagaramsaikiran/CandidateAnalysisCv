package com.capgemini.personality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.personality.entity.Skill;
import com.capgemini.personality.model.SkillDTO;
import com.capgemini.personality.service.ISkillService;

@RestController
@RequestMapping("/service")
public class SkillController {
	@Autowired
	private ISkillService skillService;

	@RequestMapping("/listskills")
	public List<SkillDTO> getAllSkills() {
		return skillService.getAllSkills();
	}

	@RequestMapping("/getskills/{skillId}")
	public SkillDTO getskill(@PathVariable int id) {
		return skillService.getSkill(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addskills")
	public SkillDTO addskill(@RequestBody Skill skill) {
		return skillService.addSkill(skill);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateskills")
	public SkillDTO updateskill(@RequestBody Skill skill) {
		return skillService.updateSkill(skill);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteskills/{skillId}")
	public SkillDTO deleteskill(int id) {
		return skillService.deleteSkill(id);
	}

}
