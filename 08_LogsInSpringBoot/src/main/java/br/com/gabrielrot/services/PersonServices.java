package br.com.gabrielrot.services;

import br.com.gabrielrot.exception.ResourceNotFoundException;
import br.com.gabrielrot.model.Person;
import br.com.gabrielrot.repository.PersonRepositoy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepositoy repository;

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all person!");

        return repository.findAll();
    }


    public Person findById(Long id) {
        logger.info("Finding one Person");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person) {
        logger.info("Creating one person!");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        repository.delete(entity);
    }

}
