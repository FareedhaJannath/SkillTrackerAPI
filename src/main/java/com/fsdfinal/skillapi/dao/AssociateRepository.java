/**
 * 
 */
package com.fsdfinal.skillapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsdfinal.skillapi.valueobject.Associate;

/**
 * @author Fareedha
 *
 */
@Repository
public interface AssociateRepository extends CrudRepository<Associate,Long>{

	
	public List<Associate> findAll();
	
	@SuppressWarnings("unchecked")
	public Associate save(Associate associate);
	
	/**
	 * @param 
	 * @return
	 */
	public Associate findByAssociateId(Integer associateId);
	
	/**
	 * @param 
	 * @return
	 */
	public Associate findByName(String associateName);
	
	/**
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	public void delete(Associate associate);
	
 
	@Query(value = "SELECT a.gender, count(DISTINCT a.associate_id) from associate  a "
			+ " LEFT OUTER JOIN associate_skills ask ON a.associate_id = ask.associate_id"
			+" WHERE ask.skill_rating > 0  GROUP BY a.gender", nativeQuery = true)
	public List<Object[]> getRatedCandidatesByGender();

}
