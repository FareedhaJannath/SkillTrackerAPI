/**
 * 
 */
package com.fsdfinal.skillapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsdfinal.skillapi.dao.AssociateDAO;
import com.fsdfinal.skillapi.valueobject.Associate;

/**
 * @author Fareedha
 *
 */
@Service
public class AssociateServiceImpl implements AssociateService {
	@Autowired
	private AssociateDAO associateDAO;
	
	/*@Autowired
	private SkillsDAO skillDAO;*/
	 

	/**
	 * @see com.fsdfinal.skillapi.service.AssociateService#getAssociates()
	 */
	@Override
	public List<Associate> getAssociates() {
		 
		return associateDAO.getAssociates();
	}

	/**
	 * @see com.fsdfinal.skillapi.service.AssociateService#addAssociate(com.fsdfinal.skillapi.valueobject.Associate)
	 */
	@Override
	public boolean addAssociate(Associate associate) {
		boolean success = false;
		Associate existAssociate = null;
		if(associate.getAssociateId()==0){
			existAssociate = associateDAO.getAssociateByName(associate.getName());
			// Check if the associate already exists
			if(existAssociate!=null 
					&& existAssociate.getName().equalsIgnoreCase(associate.getName())){
				 // associate already Exist
				success=false; 
			}else{
			 //new Associate
			 
				success= associateDAO.saveAssociate(associate) ;
		    }
		}
		return success;
	}

	/**
	 * @see com.fsdfinal.skillapi.service.AssociateService#updateAssociate(com.fsdfinal.skillapi.valueobject.Associate)
	 */
	@Override
	public boolean updateAssociate(Associate associate) {
		boolean success = false;
		Associate existAssociate = null;
		if(associate.getAssociateId()!=0){
			existAssociate = associateDAO.getAssociateById(associate.getAssociateId());
			// Check if the associate  exists
			if(existAssociate!=null 
					&& existAssociate.getName().equalsIgnoreCase(associate.getName())){
				 
				success= associateDAO.saveAssociate(associate) ;
		    }
		}
		return success;
	}

	/**
	 * @see com.fsdfinal.skillapi.service.AssociateService#deleteAssociate(java.lang.Integer)
	 */
	@Override
	public boolean deleteAssociate(Integer associateId) {
		boolean success = false;
		
		Associate associate = associateDAO.getAssociateById(associateId);
		 if(associate!=null){
			 associateDAO.deleteAssociate(associate);
			 success=true;
		 }
		return success;
	}

	/**
	 * @see com.fsdfinal.skillapi.service.AssociateService#getAssociateDetails(java.lang.Integer)
	 */
	@Override
	public Associate getAssociateDetails(Integer associateId) {
		Associate existAssociate = null;
		if(associateId!=0){
			existAssociate = associateDAO.getAssociateById(associateId);
		}
		return existAssociate;
	}

	@Override
	public List<Associate> getAssociateSummary() {
		// TODO Auto-generated method stub
		return null;
	}
		

}
