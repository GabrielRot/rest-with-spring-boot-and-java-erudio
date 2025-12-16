package br.com.gabrielrot.repository;

import br.com.gabrielrot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoy extends JpaRepository<Person, Long> {
}
