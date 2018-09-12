/**
 * 
 */
package com.fsdfinal.skillapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsdfinal.skillapi.dao.SkillsDAO;
import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillsDAO skillDAO;
	/**
	 * @see com.fsdfinal.skillapi.service.SkillService#getSkills()
	 */
	@Override
	public List<Skills> getSkills() {
		List<Skills> skills = skillDAO.getSkills();
		return skills;
	}
	
	/**
	 * @see com.fsdfinal.skillapi.service.SkillService#addSkill(com.fsdfinal.skillapi.valueobject.Skills)
	 */
	@Override
	public boolean addSkill(Skills skill){
		boolean success= false;
		Skills existSkill = null;
		
		// skill add
		if(skill.getSkillId()==0){

			existSkill = skillDAO.getSkillByName(skill.getSkillName());
				// Check if the skill already exists
				if(existSkill!=null 
						&& existSkill.getSkillName().equalsIgnoreCase(skill.getSkillName())){
					success=false;
				}else{
				// new category
 				success= skillDAO.saveSkill(skill);
			  }
		} 
		return success;
	}

	/**
	 * @see com.fsdfinal.skillapi.service.SkillService#updateSkill(com.fsdfinal.skillapi.valueobject.Skills)
	 */
	@Override
	public boolean updateSkill(Skills skill) {
		boolean success= false;
		Skills existSkill = null;
		if(skill.getSkillId()!=0){
			existSkill = skillDAO.getSkillById(skill.getSkillId());
			if(existSkill!=null){
				 //Skill Exist update name
				existSkill.setSkillName(skill.getSkillName());
				success= skillDAO.saveSkill(existSkill);
			}
			
	    }
		return success;
	}

	/**
	 * @see com.fsdfinal.skillapi.service.SkillService#deleteSkill(java.lang.Integer)
	 */
	@Override
	public boolean deleteSkill(Integer skillId) {
		boolean success= false;
		 Skills skill = skillDAO.getSkillById(skillId);
		 if(skill!=null){
			 skillDAO.deleteSkill(skill); 
			 success= true;
		 } 
		 return success;
	}

	/**
	 * @see com.fsdfinal.skillapi.service.SkillService#getSkillDetail(int)
	 */
	@Override
	public Skills getSkillDetail(int skillId) {
		 
		 Skills skill = skillDAO.getSkillById(skillId);
		return skill;
	}
		

}
