package com.api.jhlogistica.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.jhlogistica.domain.Transport;
import com.api.jhlogistica.repositories.TransportRepository;


@RestController
@RequestMapping(value = "/transports")
public class TransportController {

	@Autowired
	private TransportRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Transport>> listByPeriod(@RequestParam(name="initDate") String initDate,
	@RequestParam(name="finalDate") String finalDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		List<Transport> list = repo.listByPeriod(LocalDate.parse(initDate, formatter), LocalDate.parse(finalDate, formatter));
		return ResponseEntity.ok(list);
	}
}
