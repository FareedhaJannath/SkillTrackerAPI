/**
 * 
 */
package fsdfinal.skilllTracker;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsdfinal.skillapi.dao.AssociateDAO;
import com.fsdfinal.skillapi.service.AssociateServiceImpl;
import com.fsdfinal.skillapi.valueobject.Associate;
import com.fsdfinal.skillapi.valueobject.AssociateSkill;
import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AssociateServiceTest {	
   
	 
	
	
	 @InjectMocks
	private AssociateServiceImpl associateServiceMock;
	
	 @Mock
    private AssociateDAO associateDAOMock;
    
	
	 @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
         
        
    }

	@Test
	public void test_get_Associates() throws Exception 
	{
		
		List<Skills> Skills = Arrays.asList(
	            new Skills(1, "Core Java",false),
	            new Skills(2, "J2EE",false));
		
		List<Associate> associates = new ArrayList<Associate>();
		 
		Associate associate =  new Associate();
		
		associate.setAssociateId(1);
		associate.setName("Fareedha");
		associate.setEmail("test@test.com");
		associate.setMobile("1234");
		associate.setStatusGreen("Y");
		associate.setStatusBlue("N");
		associate.setStatusRed("N");
		associate.setRemark("Good");
		associate.setLevel1("L1");
		associate.setLevel2("L2");
		associate.setLevel3("L3");
		associate.setStrength("Quick Learner");
		associate.setWeakness("None");
				
		
        Set<AssociateSkill> associateSkills1 = new HashSet<AssociateSkill>();	
        associateSkills1.add(new AssociateSkill(1,associate,new Skills(1,"Core Java",false),2));
        associateSkills1.add( new AssociateSkill(1,associate,new Skills(2,"J2EE",false),4)); 
		associate.setAssociateSkills(associateSkills1); 
		
		Associate associate2 = new Associate(2, "Ilyas","test@test.com","1223", "Y",
    			"N", "N", "L1", null, null, "Good",
    			"Quick Learner", null,null);
		
		 Set<AssociateSkill> associateSkills2 = new HashSet<AssociateSkill>();	
	        associateSkills2.add(new AssociateSkill(1,associate2,new Skills(1,"Core Java",false),2));
	        associateSkills2.add( new AssociateSkill(1,associate2,new Skills(2,"J2EE",false),4)); 
	        associate2.setAssociateSkills(associateSkills2); 
			
        associates.add(associate2);
        
		when(associateDAOMock.getAssociates()).thenReturn(associates);
		
       List<Associate> returnAssociates = associateServiceMock.getAssociates();
		
		assertNotNull(returnAssociates);

	}
	
	 
	@Test
	public void test_get_Associate_by_id() throws Exception 
	{
		 
		Associate mockAssociate = new Associate(1, "Fareedha","test@test.com","1223", "Y",
	   			"N", "N", "L1", null, null, "Good",
	   			"Quick Learner", null,null);
			 
			Set<AssociateSkill> associateSkills = new HashSet<AssociateSkill>();	
			associateSkills.add(new AssociateSkill(1,mockAssociate,new Skills(1,"Core Java",false),2));
			associateSkills.add( new AssociateSkill(1,mockAssociate,new Skills(2,"J2EE",false),4)); 
			mockAssociate.setAssociateSkills(associateSkills); 
		 
		 List<Associate> associates = Arrays.asList(mockAssociate); 

		 when(associateDAOMock.getAssociateById(1)).thenReturn(associates.get(0));
		
		 Associate associate = associateServiceMock.getAssociateDetails(1);
		 
		 assertNotNull(associate);

	}
	
	@Test
	public void test_add_associate() throws Exception 
	{
		 
		 Associate addAssociate =new Associate(0, "Ifthikhar","test@test.com","12223", "Y",
	     			"N", "N", "L1", null, null, "Good",
	     			"Quick Learner", null,null);
				 
				Set<AssociateSkill> associateSkills = new HashSet<AssociateSkill>();	
				associateSkills.add(new AssociateSkill(1,addAssociate,new Skills(1,"Core Java",false),6));
				associateSkills.add( new AssociateSkill(1,addAssociate,new Skills(2,"J2EE",false),4)); 
				addAssociate.setAssociateSkills(associateSkills); 
		 
		 Associate existAssociate = new Associate();
		 existAssociate.setAssociateId(1);
		 existAssociate.setName("Fareedha");
		 
		 when(associateDAOMock.getAssociateByName("Ifthikhar")).thenReturn(existAssociate);
	 	 when(associateDAOMock.saveAssociate(addAssociate)).thenReturn(true);
 
	 	 boolean success = associateServiceMock.addAssociate(addAssociate);
         
	 	 assertNotNull(addAssociate);
	 	 
	 	 assertEquals(true,success);
			 
	}
	
	@Test
	public void test_update_associate() throws Exception 
	{
		 
		 Associate updateAssociate = new Associate(2, "Ifthikhar","test@test.com","122323", "Y",
	     			"N", "N", "L1", null, null, "Good",
	     			"Quick Learner", null,null);
				 
				Set<AssociateSkill> associateSkills = new HashSet<AssociateSkill>();	
				associateSkills.add(new AssociateSkill(1,updateAssociate,new Skills(1,"Core Java",false),6));
				associateSkills.add( new AssociateSkill(1,updateAssociate,new Skills(2,"J2EE",false),4)); 
				updateAssociate.setAssociateSkills(associateSkills); 
		 
		 when(associateDAOMock.getAssociateById(2)).thenReturn(updateAssociate);
	 	 when(associateDAOMock.saveAssociate(updateAssociate)).thenReturn(true);
         
	 	 boolean success = associateServiceMock.updateAssociate(updateAssociate);
	 	 
	 	 assertNotNull(updateAssociate);
	 	 
	 	 assertEquals(true,success);
			 
	}
	@Test
	public void test_delete_associate() throws Exception 
	{
		 Associate associates = new Associate(1, "Fareedha","test@test.com","1223", "Y",
	     			"N", "N", "L1", null, null, "Good",
	     			"Quick Learner", null,null); 
			 
			 Set<AssociateSkill> associateSkills = new HashSet<AssociateSkill>();	
				associateSkills.add(new AssociateSkill(1,associates,new Skills(1,"Core Java",false),6));
				associateSkills.add( new AssociateSkill(1,associates,new Skills(2,"J2EE",false),4)); 
				associates.setAssociateSkills(associateSkills); 
		  
		  when(associateDAOMock.getAssociateById(1)).thenReturn(associates);
		  
		  boolean success = associateServiceMock.deleteAssociate(1);
		 	 
		  assertEquals(true,success); 

		 	 
	} 
}
