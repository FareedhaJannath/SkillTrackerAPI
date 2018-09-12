/**
 * 
 */
package com.fsdfinal.skillapi.service;

import java.util.List;

import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
public interface SkillService {
	
	/**
	 * @return List of Skills
	 */
	public List<Skills> getSkills();
	
	/**
	 * @param skill
	 */
	public boolean addSkill(Skills skill);
	
	/**
	 * @param skill
	 */
	public boolean updateSkill(Skills skill);
	
	
	/**
	 * @param skill
	 */
	public boolean deleteSkill(Integer skillId);

	/**
	 * @param skillId
	 * @return
	 */
	public Skills getSkillDetail(int skillId);

}
