package com.example.lab10.repository;

import com.example.lab10.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path="locations")
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByCountry(String country);
    Optional<Location> findByName(String name);
}