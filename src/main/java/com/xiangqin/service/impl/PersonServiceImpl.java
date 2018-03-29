package com.xiangqin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangqin.domain.Person;
import com.xiangqin.repository.PersonRepository;
import com.xiangqin.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Integer addPerson(Person p) {
		personRepository.save(p);
		return p.getId();
	}
}
