package com.example.lab10.repository;

import com.example.lab10.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "locations")
public interface LocationRepository extends JpaRepository<Location, Long> {
    Page<Location> findByCountry(String country, Pageable pageable);
    Page<Location> findByName(String name, Pageable pageable);
}