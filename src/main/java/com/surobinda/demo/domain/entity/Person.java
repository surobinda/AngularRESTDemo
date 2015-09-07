package com.surobinda.demo.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSON_DEMO")
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name="PERSON_ID")
	@Id
	@GeneratedValue
	private long personId;
	
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;

	/**
	 * @return the personId
	 */
	public long getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(long personId) {
		this.personId = personId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
