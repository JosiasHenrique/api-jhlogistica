package com.api.jhlogistica.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.jhlogistica.domain.Fuel;
import com.api.jhlogistica.repositories.FuelRepository;

@Service
public class FuelService {
	
	@Autowired
	private FuelRepository repo;

	public List<Fuel> listByPeriod(String initDate, String finalDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<Fuel> list = repo.listByPeriod(LocalDate.parse(initDate, formatter), LocalDate.parse(finalDate, formatter));
		return list;
	}
}
