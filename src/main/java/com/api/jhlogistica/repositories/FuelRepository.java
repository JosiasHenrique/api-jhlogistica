package com.api.jhlogistica.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.jhlogistica.domain.Fuel;


public interface FuelRepository extends JpaRepository<Fuel, Long> {


	@Query("SELECT obj from Fuel obj WHERE date(obj.date) BETWEEN :initPeriod AND :finalPeriod ORDER BY obj.date DESC")
	List<Fuel> listByPeriod(@Param("initPeriod") LocalDate initDate, @Param("finalPeriod") LocalDate finalDate);
}