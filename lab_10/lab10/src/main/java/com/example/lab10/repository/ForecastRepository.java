package com.example.lab10.repository;

import com.example.lab10.entity.Forecast;
import com.example.lab10.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@RepositoryRestResource(path = "forecasts")
public interface ForecastRepository extends JpaRepository<Forecast, Long> {
    Page<Forecast> findByDateGreaterThan(
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            Pageable pageable
    );
    Page<Forecast> findByLocationId(Long locationId, Pageable pageable);

}