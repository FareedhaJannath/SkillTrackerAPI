/**
 * 
 */
package com.fsdfinal.skillapi.dao;

import java.util.List;

import com.fsdfinal.skillapi.valueobject.Associate;

/**
 * @author Fareedha
 *
 */
public interface AssociateDAO {
	 
	/**
	 * @return list of Associate
	 */
	public List<Associate>  getAssociates();
	
	/**
	 * @param  associate
	 */
	public boolean saveAssociate(Associate associate);
	
	
	/**
	 * @param associateId
	 * @return
	 */
	public Associate getAssociateById(Integer associateId);
	
	/**
	 * @param associateName
	 * @return
	 */
	public Associate getAssociateByName(String associateName);
	
	/**
	 * @param associate
	 */
	public void deleteAssociate(Associate associate);
	
	/**
	 * Rated Candiates
	 */
     public List<Object[]> getRatedCandidates();
     
}
