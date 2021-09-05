package com.covidtrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covidtrack.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
