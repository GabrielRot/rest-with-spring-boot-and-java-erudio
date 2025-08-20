package br.com.gabrielrot;

import br.com.gabrielrot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all person!");

        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Brazil");

        if (i % 2 == 0) {
            person.setGender("Male");
        } else {
            person.setGender("Female");
        }

        return person;
    }

    public Person findById(String id) {
        logger.info("Finding one Person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Gabriel");
        person.setLastName("Teixeira");
        person.setAddress("Xique xique - BA - Brazil");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person!");

        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person!");

        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person!");


    }

}
