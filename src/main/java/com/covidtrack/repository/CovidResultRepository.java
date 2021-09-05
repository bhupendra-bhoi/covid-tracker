package com.covidtrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covidtrack.model.CovidResult;

@Repository
public interface CovidResultRepository extends JpaRepository<CovidResult, Integer> {

}
