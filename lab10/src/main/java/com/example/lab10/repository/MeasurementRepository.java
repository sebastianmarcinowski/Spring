package com.example.lab10.repository;

import com.example.lab10.Location;
import com.example.lab10.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(path="measurements")
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findByDateAfterAndLocation(Date date, Location location);
}
