/**
 * 
 */
package com.fsdfinal.skillapi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
@Repository
public interface SkillsRepository extends CrudRepository<Skills,Long>{

	
	public List<Skills> findAll();
	
	@SuppressWarnings("unchecked")
	public Skills save(Skills skill);
	
	/**
	 * @param 
	 * @return
	 */
	public Skills findBySkillId(Integer skillId);
	
	/**
	 * @param 
	 * @return
	 */
	public Skills findBySkillName(String skillName);
	
	public void delete(Skills skill);

}
