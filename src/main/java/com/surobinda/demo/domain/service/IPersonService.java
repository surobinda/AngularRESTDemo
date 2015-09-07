package com.surobinda.demo.domain.service;

import java.util.List;

import com.surobinda.demo.domain.entity.Person;

public interface IPersonService 
{
	/**
	 * @param person
	 * @return
	 */
	public Person createPerson(Person person);
	
	/**
	 * @return
	 */
	public List<Person> getAllPerson();
	
	/**
	 * @param personId
	 * @return
	 */
	public Person getPersonById(long personId);
	
	/**
	 * @param person
	 * @return
	 */
	public Person updatePerson(Person person);
	
	/**
	 * @param person
	 */
	public void deletePerson(Person person);
}
