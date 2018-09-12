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

import com.fsdfinal.skillapi.dao.SkillsDAOImpl;
import com.fsdfinal.skillapi.dao.SkillsRepository;
import com.fsdfinal.skillapi.valueobject.Skills;

/**
 * @author Fareedha
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillRepositoryTest {	
   
	
	@Mock
	private SkillsRepository skillRepositoryMock;
	
	@InjectMocks
    private SkillsDAOImpl skillDAOMock;
    
	
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

		when(skillRepositoryMock.findAll()).thenReturn(Skills);
		
		List<Skills> returnSkills = skillDAOMock.getSkills();
		
		assertNotNull(returnSkills);
		 

	}
	 
	@Test
	public void test_get_Skills_by_id() throws Exception 
	{
		 
		List<Skills> Skills = Arrays.asList(
	            new Skills(1, "Core Java",false),
	            new Skills(2, "J2EE",false));

		when(skillRepositoryMock.findBySkillId(2)).thenReturn(Skills.get(1));
		
		Skills skill =skillDAOMock.getSkillById(2);
		
		assertNotNull(skill);

	}
	
	@Test
	public void test_add_Skill() throws Exception 
	{
		 
		 Skills addSkill = new Skills();
		 addSkill.setSkillId(0);
		 addSkill.setSkillName("Angular JS 2");
		 
		 when(skillRepositoryMock.findBySkillName("Angular JS 2")).thenReturn(null);
	 	 when(skillRepositoryMock.save(addSkill)).thenReturn(addSkill);
	 	 
	 	 boolean success = skillDAOMock.saveSkill(addSkill);
	 	 
	 	 assertNotNull(addSkill);
	 	 
	 	 assertEquals(true,success);
 
	}
	
	@Test
	public void test_update_Skill() throws Exception 
	{
		 
		 Skills updateSkill = new Skills();
		 updateSkill.setSkillId(1);
		 updateSkill.setSkillName("Angular JS 2");
		 
	 	 when(skillRepositoryMock.findBySkillId(1)).thenReturn(updateSkill);
	 	 when(skillRepositoryMock.save(updateSkill)).thenReturn(updateSkill);

         boolean success = skillDAOMock.saveSkill(updateSkill);
	 	 
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
         skillDAOMock.deleteSkill(skill);
	 	 
	 	 assertNotNull(skill);
	 	 
	 	  
	} 
}
