package com.api.jhlogistica.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.jhlogistica.domain.Transport;


public interface TransportRepository extends JpaRepository<Transport, Long> {

	@Query("SELECT obj from Transport obj WHERE date(obj.date) BETWEEN :initPeriod AND :finalPeriod ORDER BY obj.date DESC")
	List<Transport> listByPeriod(@Param("initPeriod") LocalDate initDate, @Param("finalPeriod") LocalDate finalDate); 
	

}
