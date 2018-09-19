/**
 * 
 */
package com.fsdfinal.skillapi.valueobject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Fareedha
 *
 */

@Entity
@Table(name = "SKILLS")
public class Skills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8999965771190613844L;
	/**
	 * Category Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SKILL_ID")
	private Integer skillId;
    /** 
     * Category Title
     */
	@Column(name="SKILL_NAME",nullable = false, length = 100)
	private String skillName;
	
	/**
	 * Associates List
	 */
	@OneToMany(mappedBy="skill")
	@JsonIgnore
	 @NotFound(action=NotFoundAction.IGNORE)
	 @Cascade({CascadeType.SAVE_UPDATE})
	private Set<AssociateSkill> associateSkills = new HashSet<AssociateSkill>();
    
    public Skills(){}

	/**
	 * @param skillId
	 * @param skillName
	 * @param editable
	 */
	public Skills(Integer skillId, String skillName, boolean editable) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		//this.editable = editable;
	}

	/**
	 * @return the skillId
	 */
	public Integer getSkillId() {
		return skillId;
	}

	/**
	 * @param skillId the skillId to set
	 */
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * @param skillName the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	/**
	 * @return the associateSkills
	 */
	public Set<AssociateSkill> getAssociateSkills() {
		return associateSkills;
	}

	/**
	 * @param associateSkills the associateSkills to set
	 */
	public void setAssociateSkills(Set<AssociateSkill> associateSkills) {

		for(AssociateSkill associateSkill:associateSkills){
			associateSkill.setSkill(this);
		}
		this.associateSkills = associateSkills;
	}

	 
 
	
}
