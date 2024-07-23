package com.practice.springboot_postgresql_CRUD_operation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer>
{

	//List<Hospital> findByPname(String pname); --->this is ued in simple method

	
}
