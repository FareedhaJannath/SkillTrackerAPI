/**
 * 
 */
package com.fsdfinal.skillapi.valueobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Fareedha
 *
 */
@Entity
@Table(name = "ASSOCIATE_SKILLS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AssociateSkill implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7513801686195881222L;
	/**
	 * associate ID
	 */
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="ASSOCIATE_SKILL_ID")
     private Integer associateSkillId;
     /**
      * associate Id
      */
	 @ManyToOne(fetch=FetchType.LAZY)
	 @Cascade({CascadeType.ALL})
	 @JoinColumn(name="ASSOCIATE_ID" )
	 @JsonIgnore
     private Associate associate;
     /**
      * skill Id
      */
	 @ManyToOne(fetch=FetchType.LAZY)
	 @Cascade({CascadeType.SAVE_UPDATE,CascadeType.MERGE})
	 @JoinColumn(name="SKILL_ID" )
     private Skills skill;
	 
	 @Column(name="skill_rating")
	 private Integer skillRating;
	 
	 public AssociateSkill(){}
	 
	  

	public AssociateSkill(Integer associateSkillId, Associate associate, Skills skill, Integer skillRating) {
		super();
		this.associateSkillId = associateSkillId;
		this.associate = associate;
		this.skill = skill;
		this.skillRating = skillRating;
	}



	/**
	 * @return the associateSkillId
	 */
	public Integer getAssociateSkillId() {
		return associateSkillId;
	}

	/**
	 * @param associateSkillId the associateSkillId to set
	 */
	public void setAssociateSkillId(Integer associateSkillId) {
		this.associateSkillId = associateSkillId;
	}

	/**
	 * @return the associate
	 */
	public Associate getAssociate() {
		return associate;
	}

	/**
	 * @param associate the associate to set
	 */
	public void setAssociate(Associate associate) {
		this.associate = associate;
	}

	/**
	 * @return the skill
	 */
	public Skills getSkill() {
		return skill;
	}

	/**
	 * @param skill the skill to set
	 */
	public void setSkill(Skills skill) {
		this.skill = skill;
	}

	/**
	 * @return the skillRating
	 */
	public Integer getSkillRating() {
		return skillRating;
	}

	/**
	 * @param skillRating the skillRating to set
	 */
	public void setSkillRating(Integer skillRating) {
		this.skillRating = skillRating;
	}
 
}
