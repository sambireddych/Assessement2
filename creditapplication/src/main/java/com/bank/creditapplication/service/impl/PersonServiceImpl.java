package com.bank.creditapplication.service.impl;

import com.bank.creditapplication.domain.Person;
import com.bank.creditapplication.repository.PersonRepository;
import com.bank.creditapplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPerson(long id) throws Exception {
        return personRepository.find(id);
    }

    @Override
    public Stream<Person> getAll() {
        return personRepository.findAll().stream().map(this::apply);
    }

    private Person apply(Long aLong) {
        try {
            return personRepository.find(aLong);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
