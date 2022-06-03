package com.api.jhlogistica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.jhlogistica.domain.Fuel;
import com.api.jhlogistica.services.FuelService;

@RestController
@RequestMapping(value = "/fuels")
public class FuelController {

	@Autowired
	private FuelService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Fuel>> listByPeriod(@RequestParam(name="initDate") String initDate,
	@RequestParam(name="finalDate") String finalDate) {
		List<Fuel> list = service.listByPeriod(initDate, finalDate);
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(list);
		}
	}
}
