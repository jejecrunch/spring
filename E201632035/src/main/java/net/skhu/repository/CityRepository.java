package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
