/**
 * @Title: PersonRepository.java
 * @Package com.lala.repository
 * Copyright: Copyright (c) 2011 
 * @author ly
 * @date Jan 29, 2015 3:49:26 PM
 * @version V1.0
 */

package com.lala.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lala.domain.Person;

/**
 * @ClassName: PersonRepository
 * @author ly
 * @date Jan 29, 2015 3:49:26 PM
 *
 */

public interface PersonRepository extends MongoRepository<Person, String>
{
	public List<Person> findByStatus(Integer status);
} 
