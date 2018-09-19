/**
 * 
 */
package com.fsdfinal.skillapi.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fsdfinal.skillapi.dao.AssociateDAO;
import com.fsdfinal.skillapi.to.SkillDashboardTO;
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

	/**
	 * @see com.fsdfinal.skillapi.service.AssociateService#getAssociateSummary()
	 */
	@Override
	public SkillDashboardTO getAssociateSummary() {
		 List<Associate> associateList = associateDAO.getAssociates();
		 List<Object[]> ratedCandidates = associateDAO.getRatedCandidates();
		 SkillDashboardTO responseTO = new SkillDashboardTO();
		 Double maleCount = 0.0;
		 Double femaleCount = 0.0;
		 Double totalAssociateCount =0.0;
		 Double freshersCount=0.0;
		 Double level2Count=0.0;
		 Double level3Count=0.0;
		 Double totalCandidateRated=0.0;
		 Double maleCandidateRated=0.0;
		 Double femaleCandidateRated=0.0;
		
		 Double malePercent=0.0;
		 Double femalePercent=0.0;
		 Double fresherPercent=0.0;
		 Double level2Percent=0.0;
		 Double level3Percent=0.0;
		 Double maleRatedPercent=0.0;
		 Double femaleRatedPercent=0.0;
		 
		 
		 if(!CollectionUtils.isEmpty(associateList)){
			 // Total Associates registered
			 totalAssociateCount =Double.valueOf(associateList.size());
			// System.out.println(".totalAssociateCount.."+totalAssociateCount);
			 for(Associate associate:associateList){
				 // Male and Female Count
				 if(associate.getGender()!=null && associate.getGender().equalsIgnoreCase("M")){
					 maleCount++;
					// System.out.println(".maleCount.."+maleCount);
				 }else if(associate.getGender()!=null && associate.getGender().equalsIgnoreCase("F")){
					 femaleCount++;
					// System.out.println(".femaleCount.."+femaleCount);
				 }
				 if(associate.getLevel1()!=null && associate.getLevel1().equalsIgnoreCase("L1")){
					 freshersCount++;
				 }else if(associate.getLevel2()!=null && associate.getLevel2().equalsIgnoreCase("L2")){
					 level2Count++;
				 }else if(associate.getLevel3()!=null && associate.getLevel3().equalsIgnoreCase("L3")){
					 level3Count++;
				 }
			 } 
			 // Rated Candidates by Gender
			 if(!CollectionUtils.isEmpty(ratedCandidates)){
				 for(Object[] associateGender:ratedCandidates){
					 if(associateGender[0].equals("M")){
						 maleCandidateRated = ((BigInteger) associateGender[1]).doubleValue();
						// System.out.println("male..rated.."+maleCandidateRated);
					 }else{
						 femaleCandidateRated =  ((BigInteger) associateGender[1]).doubleValue();
						// System.out.println("female..rated.."+femaleCandidateRated);
					 }
				 }
				 totalCandidateRated = maleCandidateRated+femaleCandidateRated;
				// System.out.println("total..rated.."+totalCandidateRated);
				 
			 }
		     // Male Percent
			 malePercent = (maleCount/totalAssociateCount)*100.0;
			 malePercent= Double.valueOf(Math.round(malePercent));
			// System.out.println("malePercent.."+malePercent);
			 // Female Percent
			 femalePercent = (femaleCount/totalAssociateCount)*100.0;
			 femalePercent= Double.valueOf(Math.round(femalePercent));
			// System.out.println("femalePercent.."+femalePercent);
			 // Freshers Percent
			 fresherPercent = (freshersCount/totalAssociateCount)*100.0;
			 fresherPercent= Double.valueOf(Math.round(fresherPercent));
			// System.out.println("fresherPercent.."+fresherPercent+".."+freshersCount);
			 // Level2 Percent
			 level2Percent = (level2Count/totalAssociateCount)*100.0;
			 level2Percent= Double.valueOf(Math.round(level2Percent));
			// System.out.println("level2Percent.."+level2Percent+".."+level2Percent);
			 // Level3 Percent
			 level3Percent = (level3Count/totalAssociateCount)*100.0;
			 level3Percent= Double.valueOf(Math.round(level3Percent));
			 //Male Rated Percent
			 maleRatedPercent = (maleCandidateRated/totalCandidateRated)*100.0;
			 maleRatedPercent= Double.valueOf(Math.round(maleRatedPercent));
			// System.out.println("fresherPercent.."+fresherPercent+".."+freshersCount);
			 //Female Rated Percent
			 femaleRatedPercent = (femaleCandidateRated/totalCandidateRated)*100.0;
			 femaleRatedPercent= Double.valueOf(Math.round(femaleRatedPercent));
			// System.out.println("fresherPercent.."+fresherPercent+".."+freshersCount);
			 
			 
			 
			 // Set the Percent to TO
			 responseTO.setMalePercentage(String.valueOf(malePercent) );
			 responseTO.setFemalePercentage(String.valueOf(femalePercent) );
			 responseTO.setAssociatesCount(String.valueOf(totalAssociateCount) );
			 responseTO.setLevel1Percentage(String.valueOf(fresherPercent));
			 responseTO.setLevel2Percentage(String.valueOf(level2Percent));
			 responseTO.setLevel3Percentage(String.valueOf(level3Percent));
			 responseTO.setFreshersPercentage(String.valueOf(fresherPercent));
			 responseTO.setRatedAssociatesCount(String.valueOf(totalCandidateRated));
			 responseTO.setMaleRatedPercentage(String.valueOf(maleRatedPercent));
			 responseTO.setFemaleRatedPercentage(String.valueOf(femaleRatedPercent));
			 
			 
		 }
		 
		 
		 return responseTO;
	}
		

}
