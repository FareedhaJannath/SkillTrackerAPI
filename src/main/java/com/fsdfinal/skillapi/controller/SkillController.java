/**
 * 
 */
package com.fsdfinal.skillapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsdfinal.skillapi.service.SkillService;
import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
@RestController
@RequestMapping("/Skills")
public class SkillController {
	@Autowired
	private SkillService skillService;
	
	/**
	 * @return list of skills
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Skills> getSkills() 
	{
		List<Skills> skills = skillService.getSkills();
	 
		return skills;
	}
	
	/**
	 * @param associateId
	 * @return
	 */
	@RequestMapping(path="/skillId/{id}",method = RequestMethod.GET)
	public Skills getSkillDetails(@PathVariable("id") int skillId) 
	{
		Skills skill = new Skills();
		 
		skill= skillService.getSkillDetail(skillId);
		 
		return skill;
	}
	
	/**
	 * @param skill
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public boolean addSkill(@RequestBody Skills skill) 
	{
		 boolean success = false;
		 if(skill.getSkillId()==null){
			 // set skill id to zero for new skill
			 skill.setSkillId(0);
		 }
		 success= skillService.addSkill(skill);
		 
		return success;
	}
	
	/**
	 * @param skill
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public boolean updateSkill(@RequestBody Skills skill) 
	{
		 boolean success = false;
		 if(skill.getSkillId()!=null){
			 success= skillService.updateSkill(skill);  
		 }
		 
		return success;
	}
	
	/**
	 * @param skillId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public boolean deleteSkill(@PathVariable("id") int skillId) 
	{
		boolean success = false;
		 
		success= skillService.deleteSkill(skillId); 
		
		return success;
	} 
}
