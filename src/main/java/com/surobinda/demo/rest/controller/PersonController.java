package com.surobinda.demo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surobinda.demo.domain.entity.Person;
import com.surobinda.demo.domain.service.IPersonService;

@RestController
@EnableWebMvc
public class PersonController implements IPersonController 
{
	@Autowired
	private IPersonService personService;
	
	@Override
	@RequestMapping(value="/person",method = RequestMethod.POST, consumes="application/json")
	public Person createPerson(@RequestBody String person) 
	{
		System.out.println("Person:: " + person);
		Person p = null;
		
		try
		{
			p = new ObjectMapper().readValue(person, Person.class);	
		}
		catch(Exception ex)
		{
			//TODO do something
		}
		
		System.out.println("Inside Create Person:: " + p);
		System.out.println("Inside Create Person.firstName:: " + p.getFirstName());
		System.out.println("Inside Create Person.lastname:: " + p.getLastName());
		return personService.createPerson(p);
	}

	@Override
	@RequestMapping(value="/person",method = RequestMethod.GET)
	public List<Person> getAllPerson() 
	{
		System.out.println("********************Inside getAllPerson ******************");
		List<Person> persons = personService.getAllPerson();
		return persons;
	}

	@Override
	public Person getPersonById(long personId) 
	{
		return personService.getPersonById(personId);
	}

	@Override
	public Person updatePerson(Person person) 
	{
		return personService.updatePerson(person);
	}

	@Override
	public void deletePerson(Person person) 
	{
		personService.deletePerson(person);
	}
}
