/**
 * 
 */
package fsdfinal.skilllTracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fsdfinal.skillapi.dao.SkillsDAO;
import com.fsdfinal.skillapi.service.SkillServiceImpl;
import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillServiceTest {	
   
	
	@InjectMocks
	private SkillServiceImpl skillServiceMock;
	
    @Mock
    private SkillsDAO skillDAOMock;
    
	
	 @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        
    }

	@Test
	public void test_get_Skills() throws Exception 
	{
		 
		List<Skills> Skills = Arrays.asList(
	            new Skills(1, "Core Java",false),
	            new Skills(2, "J2EE",false)); 

		when(skillServiceMock.getSkills()).thenReturn(Skills);
		
		List<Skills> returnSkills = skillServiceMock.getSkills();
		
		assertNotNull(returnSkills);
		 

	}
	 
	@Test
	public void test_get_Skills_by_id() throws Exception 
	{
		 
		List<Skills> Skills = Arrays.asList(
	            new Skills(1, "Core Java",false),
	            new Skills(2, "J2EE",false));

		when(skillServiceMock.getSkillDetail(2)).thenReturn(Skills.get(1));
		
		Skills skill =skillServiceMock.getSkillDetail(2);
		
		assertNotNull(skill);

	}
	
	@Test
	public void test_add_Skill() throws Exception 
	{
		 
		 Skills addSkill = new Skills();
		 addSkill.setSkillId(0);
		 addSkill.setSkillName("Angular JS 2");
		 
		 when(skillDAOMock.getSkillByName("Angular JS 2")).thenReturn(new Skills(1,"Core Java",false));
	 	 when(skillDAOMock.saveSkill(addSkill)).thenReturn(true);
	 	 
	 	 boolean success = skillServiceMock.addSkill(addSkill);
	 	 
	 	 assertNotNull(addSkill);
	 	 
	 	 assertEquals(true,success);
 
	}
	
	@Test
	public void test_update_Skill() throws Exception 
	{
		 
		 Skills updateSkill = new Skills();
		 updateSkill.setSkillId(1);
		 updateSkill.setSkillName("Angular JS 2");
		 
	 	 when(skillDAOMock.getSkillById(1)).thenReturn(updateSkill);
	 	 when(skillDAOMock.saveSkill(updateSkill)).thenReturn(true);

         boolean success = skillServiceMock.updateSkill(updateSkill);
	 	 
	 	 assertNotNull(updateSkill);
	 	 
	 	 assertEquals(success,true);
	}
	@Test
	public void test_delete_Skill() throws Exception 
	{
	 	 
		 Skills skill = new Skills();
		 skill.setSkillId(1);
		 skill.setSkillName("Angular JS 2");
		 
		 when(skillDAOMock.getSkillById(1)).thenReturn(skill);
         boolean success = skillServiceMock.deleteSkill(1);
	 	 
	 	 //assertNotNull(updateSkill);
	 	 
	 	 assertEquals(true,success);	 
	} 
}
