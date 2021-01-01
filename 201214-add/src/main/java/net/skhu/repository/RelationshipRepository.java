package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Integer>  {

}

