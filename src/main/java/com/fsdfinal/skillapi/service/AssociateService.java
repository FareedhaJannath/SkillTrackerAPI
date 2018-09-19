/**
 * 
 */
package com.fsdfinal.skillapi.service;

import java.util.List;

import com.fsdfinal.skillapi.to.SkillDashboardTO;
import com.fsdfinal.skillapi.valueobject.Associate;

/**
 * @author Fareedha
 *
 */
public interface AssociateService {
	
	/**
	 * @return List of Associates
	 */
	public List<Associate> getAssociates();
	
	/**
	 * @return SkillDashboardTO
	 */
	public SkillDashboardTO getAssociateSummary();
	
	/**
	 * @param associate
	 */
	public boolean addAssociate(Associate associate);
	
	/**
	 * @param associate
	 */
	public boolean updateAssociate(Associate associate);
	
	/**
	 * @param associateId
	 * @return
	 */
	public boolean deleteAssociate(Integer associateId);
	
	/**
	 * @param associateId
	 * @return
	 */
	public Associate getAssociateDetails(Integer associateId);
	 

}
