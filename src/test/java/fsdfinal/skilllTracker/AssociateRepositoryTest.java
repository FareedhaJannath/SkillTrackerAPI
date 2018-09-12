/**
 * 
 */
package fsdfinal.skilllTracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fsdfinal.skillapi.dao.AssociateDAOImpl;
import com.fsdfinal.skillapi.dao.AssociateRepository;
import com.fsdfinal.skillapi.valueobject.Associate;
import com.fsdfinal.skillapi.valueobject.AssociateSkill;
import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AssociateRepositoryTest {	
   
	 
	
	
	 @Mock
	private AssociateRepository associateRepositoryMock;
	
	
	 @InjectMocks
    private AssociateDAOImpl associateDAOMock;
    
	
	 @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
         
        
    }

	@Test
	public void test_get_Associates() throws Exception 
	{
		 
		
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
				
		
			Set<AssociateSkill> associateSkills = new HashSet<AssociateSkill>();	
			associateSkills.add(new AssociateSkill(1,associate,new Skills(1,"Core Java",false),2));
			associateSkills.add( new AssociateSkill(1,associate,new Skills(2,"J2EE",false),4)); 
			associate.setAssociateSkills(associateSkills); 
		
	    associates.add(associate);

		when(associateRepositoryMock.findAll()).thenReturn(associates);
		
       List<Associate> returnAssociates = associateDAOMock.getAssociates();
		
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

		 when(associateRepositoryMock.findByAssociateId(1)).thenReturn(associates.get(0));
		
		 Associate associate = associateDAOMock.getAssociateById(1);
		 
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
		 
		 when(associateRepositoryMock.findByName("Ifthikhar")).thenReturn(existAssociate);
	 	 when(associateRepositoryMock.save(addAssociate)).thenReturn(addAssociate);
 
	 	 boolean success = associateDAOMock.saveAssociate(addAssociate);
         
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
		 
		 when(associateRepositoryMock.findByAssociateId(2)).thenReturn(updateAssociate);
	 	 when(associateRepositoryMock.save(updateAssociate)).thenReturn(updateAssociate);
         
	 	 boolean success = associateDAOMock.saveAssociate(updateAssociate);
	 	 
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
		  
		  when(associateRepositoryMock.findByAssociateId(1)).thenReturn(associates);
		  
		  associateDAOMock.deleteAssociate(associates);
		 	 
		  assertNotNull(associates);

		 	 
	} 
}
