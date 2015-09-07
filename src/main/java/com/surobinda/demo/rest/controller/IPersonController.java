package com.surobinda.demo.rest.controller;

import java.util.List;

import com.surobinda.demo.domain.entity.Person;


public interface IPersonController 
{
	/**
	 * @param person
	 * @return
	 */
	public Person createPerson(String user) ;
	
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
