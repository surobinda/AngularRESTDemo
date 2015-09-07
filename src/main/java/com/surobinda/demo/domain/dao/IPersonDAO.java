package com.surobinda.demo.domain.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.surobinda.demo.domain.entity.Person;

@Repository
public interface IPersonDAO extends CrudRepository<Person, Long>{
}
