/**
 * 
 */
package com.fsdfinal.skillapi.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fsdfinal.skillapi.valueobject.Associate;

/**
 * @author Fareedhaf
 *
 */

@Transactional
@Repository
public class AssociateDAOImpl implements AssociateDAO {
	/**
	 * Logger implementation for DAO Layer
	 */
	private static Logger log=Logger.getLogger(AssociateDAOImpl.class);
	/**
	 * Workout Repository
	 */
	@Autowired
	public AssociateRepository associateRepository;
 

 
	/**
	 * @see com.fsdfinal.skillapi.dao.AssociateDAO#getAssociates()
	 */
	@Override
	public List<Associate> getAssociates() {
		 log.info("Get Associate Lists");
		return associateRepository.findAll();
	}

	 
	@Override
	public boolean saveAssociate(Associate associate) {
		boolean successSave = false;
		associate = associateRepository.save(associate);
		
		if (associate.getAssociateId()!=null)
			successSave=true;
		return successSave; 
	}

	/**
	 * @see com.fsdfinal.skillapi.dao.AssociateDAO#getAssociateById(java.lang.Integer)
	 */
	@Override
	public Associate getAssociateById(Integer associateId) {
		 
		return associateRepository.findByAssociateId(associateId);
	}

	/**
	 * @see com.fsdfinal.skillapi.dao.AssociateDAO#getAssociateByName(java.lang.String)
	 */
	@Override
	public Associate getAssociateByName(String associateName) {
		 
		return associateRepository.findByName(associateName);
	}

	/**
	 * @see com.fsdfinal.skillapi.dao.AssociateDAO#deleteAssociate(com.fsdfinal.skillapi.valueobject.Associate)
	 */
	@Override
	public void deleteAssociate(Associate associate) {
		associateRepository.delete(associate);
		
	}

	 
    
	
	

}
