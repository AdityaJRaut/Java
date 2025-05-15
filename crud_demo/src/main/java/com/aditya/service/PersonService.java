package com.aditya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aditya.exception.PersonNotFoundException;
import com.aditya.model.Person;
import com.aditya.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void save(Person person)
    {
		personRepository.save(person);
	}
    
    public Optional<Person> findById(long id)
    {
    	Optional<Person> person =personRepository.findById(id);
    	if(person.isPresent())
    	{
    		return person;
    	}
    	else
    	{
    		throw new PersonNotFoundException("Person Not found with id : "+id);
    	}
    	
    }

	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public void deletePerson(long id)
	{
		personRepository.deleteById(id);
	}
	
	public Page<Person> personByPages(int pageNumber,int pageSize)
	{
		return personRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}
}
