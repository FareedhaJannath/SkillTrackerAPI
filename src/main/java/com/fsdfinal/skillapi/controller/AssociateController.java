/**
 * 
 */
package com.fsdfinal.skillapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsdfinal.skillapi.service.AssociateService;
import com.fsdfinal.skillapi.to.SkillDashboardTO;
import com.fsdfinal.skillapi.valueobject.Associate;

/**
 * @author Fareedha
 *
 */
@RestController
@RequestMapping("/Associate")
public class AssociateController {
	
	@Autowired
	private AssociateService associateService;
	
	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Associate> getAssociates() 
	{
		 
		List<Associate> associates = associateService.getAssociates();
 
		return associates;
	}
	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/summary")
	public SkillDashboardTO getAssociateSummary() 
	{
		SkillDashboardTO responseTO = new SkillDashboardTO();
		responseTO = associateService.getAssociateSummary();
 
		return responseTO;
	}
	/**
	 * @param associateId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Associate getAssociateDetails(@PathVariable("id") int associateId) 
	{
		Associate associate = new Associate();
		 
		associate= associateService.getAssociateDetails(associateId);
		 
		return associate;
	}
	
	/**
	 * @param associate
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public boolean addAssociate(@RequestBody Associate associate) 
	{
	   boolean success = false;
		 
	   success= associateService.addAssociate(associate);
		 
		return success;
	}
	
	/**
	 * @param associate
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public boolean updateAssociate(@RequestBody Associate associate) 
	{
	   boolean success = false;
		 
	   success= associateService.updateAssociate(associate);
		 
		return success;
	}
	/**
	 * @param associateId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public boolean deleteAssociate(@PathVariable("id") int associateId) 
	{
		boolean success = false;
		
		success= associateService.deleteAssociate(associateId);
	
		return success;
	}
	
}
