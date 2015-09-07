package com.surobinda.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surobinda.demo.domain.dao.IPersonDAO;
import com.surobinda.demo.domain.entity.Person;

@Service
public class PersonService implements IPersonService 
{
	@Autowired
	private IPersonDAO personDAO;

	@Override
	public Person createPerson(Person person) {
		return personDAO.save(person);
	}

	@Override
	public List<Person> getAllPerson() {
		return (List<Person>) personDAO.findAll();
	}

	@Override
	public Person getPersonById(long personId) {
		return personDAO.findOne(personId);
	}

	@Override
	public Person updatePerson(Person person) {
		return personDAO.save(person);
	}

	@Override
	public void deletePerson(Person person) {
		personDAO.delete(person);
	}

}
