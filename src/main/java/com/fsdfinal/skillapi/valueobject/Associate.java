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

/**
 * @author Fareedha
 *
 */
@Entity
@Table(name = "ASSOCIATE")
public class Associate implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3519253830338698605L;
	
	/**
	 * associate ID
	 */
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="ASSOCIATE_ID")
     private Integer associateId;
     /**
      * name
      */
	 @Column(name="NAME")
     private String name;
     /**
      * email
      */
	 @Column(name="EMAIL")
     private String email;
	 /**
	  * Gender
	  */
	 @Column(name="GENDER")
	 private String gender;
     /**
      * mobile
      */
	 @Column(name="MOBILE")
     private String mobile;
     /**
      * green status
      */
	 @Column(name="STATUS_GREEN")
     private String statusGreen;
     /**
      * blue status
      */
	 @Column(name="STATUS_BLUE")
     private String statusBlue;
     /**
      * red status
      */
	 @Column(name="STATUS_RED")
     private String statusRed;
     /**
      * Level 1
      */
	 @Column(name="LEVEL_1")
     private String level1;
     /**
      * Level 2
      */
	 @Column(name="LEVEL_2")
     private String level2;
     /**
      * Level 1
      */
	 @Column(name="LEVEL_3")
     private String level3;
     /**
      * remark
      */
	 @Column(name="REMARK")
     private String remark;
     /**
      * strength
      */
	  @Column(name="STRENGTH")
      private String strength;
     /**
      * weakness
      */
	 @Column(name="WEAKNESS")
     private String weakness;
	 
	/* @OneToMany(cascade = { 
		        CascadeType.PERSIST, 
		        CascadeType.MERGE
		    })
		    @JoinTable(name = "associate_skills",
		        joinColumns = @JoinColumn(name = "associate_id"),
		        inverseJoinColumns = @JoinColumn(name = "skill_id")
		    ) */
	 @OneToMany(mappedBy="associate")
	 @NotFound(action=NotFoundAction.IGNORE)
	 @Cascade({CascadeType.DELETE,CascadeType.SAVE_UPDATE,CascadeType.MERGE,CascadeType.ALL})
 	 private Set<AssociateSkill> associateSkills = new HashSet<AssociateSkill>();
	 
	 public Associate(){};
	 
	public Associate(Integer associateId, String name, String email, String mobile, String statusGreen,
			String statusBlue, String statusRed, String level1, String level2, String level3, String remark,
			String strength, String weakness, Set<AssociateSkill> associateSkills) {
		super();
		this.associateId = associateId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.statusGreen = statusGreen;
		this.statusBlue = statusBlue;
		this.statusRed = statusRed;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.remark = remark;
		this.strength = strength;
		this.weakness = weakness;
		this.associateSkills = associateSkills;
	} 
	/**
	 * @return the associateId
	 */
	public Integer getAssociateId() {
		return associateId;
	}
	/**
	 * @param associateId the associateId to set
	 */
	public void setAssociateId(Integer associateId) {
		this.associateId = associateId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the statusGreen
	 */
	public String getStatusGreen() {
		return statusGreen;
	}
	/**
	 * @param statusGreen the statusGreen to set
	 */
	public void setStatusGreen(String statusGreen) {
		this.statusGreen = statusGreen;
	}
	/**
	 * @return the statusBlue
	 */
	public String getStatusBlue() {
		return statusBlue;
	}
	/**
	 * @param statusBlue the statusBlue to set
	 */
	public void setStatusBlue(String statusBlue) {
		this.statusBlue = statusBlue;
	}
	/**
	 * @return the statusRed
	 */
	public String getStatusRed() {
		return statusRed;
	}
	/**
	 * @param statusRed the statusRed to set
	 */
	public void setStatusRed(String statusRed) {
		this.statusRed = statusRed;
	}
	/**
	 * @return the level1
	 */
	public String getLevel1() {
		return level1;
	}
	/**
	 * @param level1 the level1 to set
	 */
	public void setLevel1(String level1) {
		this.level1 = level1;
	}
	/**
	 * @return the level2
	 */
	public String getLevel2() {
		return level2;
	}
	/**
	 * @param level2 the level2 to set
	 */
	public void setLevel2(String level2) {
		this.level2 = level2;
	}
	/**
	 * @return the level3
	 */
	public String getLevel3() {
		return level3;
	}
	/**
	 * @param level3 the level3 to set
	 */
	public void setLevel3(String level3) {
		this.level3 = level3;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the strength
	 */
	public String getStrength() {
		return strength;
	}
	/**
	 * @param strength the strength to set
	 */
	public void setStrength(String strength) {
		this.strength = strength;
	}
	/**
	 * @return the weakness
	 */
	public String getWeakness() {
		return weakness;
	}
	/**
	 * @param weakness the weakness to set
	 */
	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
			associateSkill.setAssociate(this);
		}
		this.associateSkills = associateSkills;
	}

     
     
}
