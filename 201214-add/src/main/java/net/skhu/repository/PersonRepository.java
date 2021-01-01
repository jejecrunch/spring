package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>  {

	List<Person> findByRelationshipTitle(String title);
}

