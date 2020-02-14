package com.bank.creditapplication.repository;


import com.bank.creditapplication.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    private static final List<Person> personStore = new ArrayList<>();

    static {
        personStore.add(new Person(1L, "sambi", "chanimella", "08854", "098-38-2992", "9027808981234567"));
        personStore.add(new Person(2L, "Hana", "Godfrey", "08764", "087-99-8754", "9029208921234567"));
        personStore.add(new Person(3L, "sambi Reddy", "chanimella", "08876", "023-24-5765", "9029208981263567"));
        personStore.add(new Person(4L, "Sai", "Krishna", "08823", "023-22-3365", "9029208345263567"));

    }

    public Person find(final long id) throws Exception {
        return personStore.stream().filter(customer -> customer.getId() == id)
                .findFirst().orElseThrow(Exception::new);
    }

    public List<Long> findAll() {
        return personStore.stream().map(Person::getId).collect(Collectors.toList());
    }
}
