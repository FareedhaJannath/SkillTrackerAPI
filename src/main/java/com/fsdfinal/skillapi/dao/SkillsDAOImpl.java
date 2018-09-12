/**
 * 
 */
package com.fsdfinal.skillapi.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */

@Transactional
@Repository
public class SkillsDAOImpl implements SkillsDAO {
	/**
	 * Logger implementation for DAO Layer
	 */
	private static Logger log=Logger.getLogger(SkillsDAOImpl.class);
	/**
	 * Category Repository
	 */
	@Autowired
	public SkillsRepository skillRepository;
	 

	@Override
	public List<Skills> getSkills() {
		log.info("getSkills");
		return skillRepository.findAll();
	}

	@Override
	public boolean saveSkill(Skills skill) {
		boolean successSave = false;
		skill = skillRepository.save(skill);
		
		if (skill.getSkillId()!=null)
			successSave=true;
		return successSave;
	}

	@Override
	public Skills getSkillById(Integer skillId) {
		return skillRepository.findBySkillId(skillId);
	}

	@Override
	public Skills getSkillByName(String skillName) {
		return skillRepository.findBySkillName(skillName);
	}

	@Override
	public void deleteSkill(Skills skill) {
		skillRepository.delete(skill);
	}
	 

}
