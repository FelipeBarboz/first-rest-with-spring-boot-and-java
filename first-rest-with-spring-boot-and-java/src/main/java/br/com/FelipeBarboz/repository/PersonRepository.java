package br.com.FelipeBarboz.repository;

import br.com.FelipeBarboz.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
