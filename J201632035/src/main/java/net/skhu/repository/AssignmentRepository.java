package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer>  {

    List<Assignment> findByProjectId(int id);

}

