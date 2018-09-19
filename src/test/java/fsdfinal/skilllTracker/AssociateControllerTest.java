/**
 * 
 */
package fsdfinal.skilllTracker;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsdfinal.skillapi.controller.AssociateController;
import com.fsdfinal.skillapi.service.AssociateService;
import com.fsdfinal.skillapi.to.SkillDashboardTO;
import com.fsdfinal.skillapi.valueobject.Associate;
import com.fsdfinal.skillapi.valueobject.AssociateSkill;
import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AssociateControllerTest {	
   
	private MockMvc mockMvc;
	
	@Mock
	private AssociateService associateServiceMock;
	
    @InjectMocks
    private AssociateController associateControllerMock;
    
	
	 @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
         
        mockMvc = MockMvcBuilders
                .standaloneSetup(associateControllerMock)
                .build();
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
		
        associates.add( new Associate(2, "Ilyas","test@test.com","1223", "Y",
	        			"N", "N", "L1", null, null, "Good",
	        			"Quick Learner", null,associateSkills));

		when(associateServiceMock.getAssociates()).thenReturn(associates);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/Associate"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[1].associateId", Matchers.is(2)))
		.andExpect(jsonPath("$[1].name", Matchers.is("Ilyas")))	
		.andExpect(jsonPath("$[1].email", Matchers.is("test@test.com")))
		.andExpect(jsonPath("$[1].mobile", Matchers.is("1223")))	;

	}
	
	 
	@Test
	public void test_get_Associate_by_id() throws Exception 
	{
	   Associate associate = new Associate(1, "Fareedha","test@test.com","1223", "Y",
   			"N", "N", "L1", null, null, "Good",
   			"Quick Learner", null,null);
		 
		Set<AssociateSkill> associateSkills = new HashSet<AssociateSkill>();	
		associateSkills.add(new AssociateSkill(1,associate,new Skills(1,"Core Java",false),2));
		associateSkills.add( new AssociateSkill(1,associate,new Skills(2,"J2EE",false),4)); 
		associate.setAssociateSkills(associateSkills); 
		 
		 List<Associate> associates = Arrays.asList(associate
	            ); 

		 when(associateControllerMock.getAssociateDetails(1)).thenReturn(associates.get(0));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/Associate/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.associateId", Matchers.is(1)))
		.andExpect(jsonPath("$.name", Matchers.is("Fareedha")))	
		.andExpect(jsonPath("$.email", Matchers.is("test@test.com")))
		.andExpect(jsonPath("$.mobile", Matchers.is("1223")))	;

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
		 
		 String body = (new ObjectMapper()).valueToTree(addAssociate).toString();
	 	 when(associateControllerMock.addAssociate(addAssociate)).thenReturn(true);

			mockMvc.perform(MockMvcRequestBuilders.post("/Associate").contentType(MediaType.APPLICATION_JSON_VALUE).content(body))
						.andExpect(status().isOk()); 
	}
	
	@Test
	public void test_update_associate() throws Exception 
	{
	 
		 Associate addAssociate = new Associate(2, "Ifthikhar","test@test.com","122323", "Y",
	     			"N", "N", "L1", null, null, "Good",
	     			"Quick Learner", null,null);
				 
				Set<AssociateSkill> associateSkills = new HashSet<AssociateSkill>();	
				associateSkills.add(new AssociateSkill(1,addAssociate,new Skills(1,"Core Java",false),6));
				associateSkills.add( new AssociateSkill(1,addAssociate,new Skills(2,"J2EE",false),4)); 
				addAssociate.setAssociateSkills(associateSkills); 
				
		String body = (new ObjectMapper()).valueToTree(addAssociate).toString();
	 	 when(associateControllerMock.updateAssociate(addAssociate)).thenReturn(true);

			mockMvc.perform(MockMvcRequestBuilders.put("/Associate").contentType(MediaType.APPLICATION_JSON_VALUE).content(body))
						.andExpect(status().isOk()); 
	}
	@Test
	public void test_delete_associate() throws Exception 
	{
	 	 
	 	 when(associateControllerMock.deleteAssociate(1)).thenReturn(true);

		 	mockMvc.perform(MockMvcRequestBuilders.delete("/Associate/1").contentType(MediaType.APPLICATION_JSON_VALUE))
						.andExpect(status().isOk()); 
	} 
	
	@Test
	public void test_get_associateSymmary() throws Exception 
	{
	 	 
		  
         SkillDashboardTO responseTO = new SkillDashboardTO();
		  
		  responseTO.setAssociatesCount("20");
		  responseTO.setFemalePercentage("48.0");
		  responseTO.setMalePercentage("52.0");
		  responseTO.setFemaleRatedPercentage("48.0");
		  responseTO.setMaleRatedPercentage("52.0");
		  responseTO.setFreshersPercentage("30.0");
		  responseTO.setLevel1Percentage("30.0");
		  responseTO.setLevel2Percentage("40.0");
		  responseTO.setLevel3Percentage("30.0");
		  responseTO.setRatedAssociatesCount("20");
		  
			List<Skills> Skills = Arrays.asList(new Skills(1, "Core Java", false), new Skills(2, "J2EE", false));

			List<Associate> associates = new ArrayList<Associate>();

			Associate associate = new Associate();

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
			associateSkills1.add(new AssociateSkill(1, associate, new Skills(1, "Core Java", false), 2));
			associateSkills1.add(new AssociateSkill(1, associate, new Skills(2, "J2EE", false), 4));
			associate.setAssociateSkills(associateSkills1);

			Associate associate2 = new Associate(2, "Ilyas", "test@test.com", "1223", "Y", "N", "N", "L1", null, null,
					"Good", "Quick Learner", null, null);

			Set<AssociateSkill> associateSkills2 = new HashSet<AssociateSkill>();
			associateSkills2.add(new AssociateSkill(1, associate2, new Skills(1, "Core Java", false), 2));
			associateSkills2.add(new AssociateSkill(1, associate2, new Skills(2, "J2EE", false), 4));
			associate2.setAssociateSkills(associateSkills2);

			associates.add(associate2);

			when(associateServiceMock.getAssociates()).thenReturn(associates);

			List<Associate> returnAssociates = associateServiceMock.getAssociates();
			
		   when(associateServiceMock.getAssociateSummary()).thenReturn(responseTO);

			assertNotNull(returnAssociates);
		 
		 	 
		  assertNotNull(responseTO); 
		  mockMvc.perform(MockMvcRequestBuilders.get("/Associate/summary"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.associatesCount", Matchers.is("20")))
			.andExpect(jsonPath("$.femalePercentage", Matchers.is("48.0")))	
			.andExpect(jsonPath("$.malePercentage", Matchers.is("52.0")))	
			.andExpect(jsonPath("$.femaleRatedPercentage", Matchers.is("48.0")))	
			.andExpect(jsonPath("$.maleRatedPercentage", Matchers.is("52.0")))
			.andExpect(jsonPath("$.freshersPercentage", Matchers.is("30.0")))
			.andExpect(jsonPath("$.level1Percentage", Matchers.is("30.0")))	
			.andExpect(jsonPath("$.level2Percentage", Matchers.is("40.0")))	
			.andExpect(jsonPath("$.level3Percentage", Matchers.is("30.0")))
			.andExpect(jsonPath("$.ratedAssociatesCount", Matchers.is("20")));

		 	 
	} 
}
