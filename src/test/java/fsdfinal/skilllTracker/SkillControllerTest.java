/**
 * 
 */
package fsdfinal.skilllTracker;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

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
import com.fsdfinal.skillapi.controller.SkillController;
import com.fsdfinal.skillapi.service.SkillService;
import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillControllerTest {	
   
	private MockMvc mockMvc;
	
	@Mock
	private SkillService skillServiceMock;
	
    @InjectMocks
    private SkillController skillControllerMock;
    
	
	 @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
         
        mockMvc = MockMvcBuilders
                .standaloneSetup(skillControllerMock)
                .build();
    }

	@Test
	public void test_get_Skills() throws Exception 
	{
		 
		List<Skills> Skills = Arrays.asList(
	            new Skills(1, "Core Java",false),
	            new Skills(2, "J2EE",false));

		when(skillServiceMock.getSkills()).thenReturn(Skills);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/Skills"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].skillId", Matchers.is(1)))
		.andExpect(jsonPath("$[0].skillName", Matchers.is("Core Java")))	
		.andExpect(jsonPath("$[1].skillId", Matchers.is(2)))
		.andExpect(jsonPath("$[1].skillName", Matchers.is("J2EE")))	;

	}
	
	@Test
	public void test_get_Skills_by_id() throws Exception 
	{
		 
		List<Skills> Skills = Arrays.asList(
	            new Skills(1, "Core Java",false),
	            new Skills(2, "J2EE",false));

		when(skillServiceMock.getSkillDetail(2)).thenReturn(Skills.get(1));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/Skills/skillId/2"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.skillId", Matchers.is(2)))
		.andExpect(jsonPath("$.skillName", Matchers.is("J2EE")))	;

	}
	
	@Test
	public void test_add_Skill() throws Exception 
	{
		 
		 Skills addSkill = new Skills();
		 addSkill.setSkillId(0);
		 addSkill.setSkillName("Angular JS 2");
		 
		 String body = (new ObjectMapper()).valueToTree(addSkill).toString();
	 	 when(skillServiceMock.addSkill(addSkill)).thenReturn(true);

			mockMvc.perform(MockMvcRequestBuilders.post("/Skills").contentType(MediaType.APPLICATION_JSON_VALUE).content(body))
						.andExpect(status().isOk());
	}
	
	@Test
	public void test_update_Skill() throws Exception 
	{
		 
		 Skills updateSkill = new Skills();
		 updateSkill.setSkillId(1);
		 updateSkill.setSkillName("Angular JS 2");
		 
		 String body = (new ObjectMapper()).valueToTree(updateSkill).toString();
	 	 when(skillServiceMock.updateSkill(updateSkill)).thenReturn(true);

			mockMvc.perform(MockMvcRequestBuilders.put("/Skills").contentType(MediaType.APPLICATION_JSON_VALUE).content(body))
						.andExpect(status().isOk());
	}
	@Test
	public void test_delete_Skill() throws Exception 
	{
	 	 
		// String body = (new ObjectMapper()).valueToTree(updateSkill).toString();
	 	 when(skillServiceMock.deleteSkill(1)).thenReturn(true);

			mockMvc.perform(MockMvcRequestBuilders.delete("/Skills/1").contentType(MediaType.APPLICATION_JSON_VALUE))
						.andExpect(status().isOk());
	}
}
