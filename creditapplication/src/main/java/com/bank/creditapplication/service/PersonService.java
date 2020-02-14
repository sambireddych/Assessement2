package com.bank.creditapplication.service;

import com.bank.creditapplication.domain.Person;

import java.util.List;
import java.util.stream.Stream;

public interface PersonService {

    Person getPerson(final long id) throws Exception;
    Stream<Person> getAll();
}
