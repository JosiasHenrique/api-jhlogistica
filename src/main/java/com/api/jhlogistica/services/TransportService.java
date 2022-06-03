package com.api.jhlogistica.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.jhlogistica.domain.Transport;
import com.api.jhlogistica.repositories.TransportRepository;

@Service
public class TransportService {
	
	@Autowired
	private TransportRepository repo;

	public List<Transport> listByPeriod(String initDate, String finalDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<Transport> list = repo.listByPeriod(LocalDate.parse(initDate, formatter), LocalDate.parse(finalDate, formatter));
		return list;
	}
}
