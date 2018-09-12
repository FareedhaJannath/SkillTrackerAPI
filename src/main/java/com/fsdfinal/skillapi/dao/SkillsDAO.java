/**
 * 
 */
package com.fsdfinal.skillapi.dao;

import java.util.List;

import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
public interface SkillsDAO {
	 
	/**
	 * @return list of skills
	 */
	public List<Skills>  getSkills();
	
	/**
	 * @param skill
	 */
	public boolean saveSkill(Skills skill);
	
	/**
	 * @param skillId
	 * @return
	 */
	public Skills getSkillById(Integer skillId);
	
	/**
	 * @param skillName
	 * @return
	 */
	public Skills getSkillByName(String skillName);
	
	/**
	 * @param skill
	 */
	public void deleteSkill(Skills skill);

}
