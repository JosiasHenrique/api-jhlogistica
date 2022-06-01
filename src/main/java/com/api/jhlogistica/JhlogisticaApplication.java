package com.api.jhlogistica;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.jhlogistica.domain.Driver;
import com.api.jhlogistica.domain.Fuel;
import com.api.jhlogistica.domain.Transport;
import com.api.jhlogistica.domain.Truck;
import com.api.jhlogistica.domain.enums.Status;
import com.api.jhlogistica.repositories.DriverRepository;
import com.api.jhlogistica.repositories.FuelRepository;
import com.api.jhlogistica.repositories.TransportRepository;
import com.api.jhlogistica.repositories.TruckRepository;

@SpringBootApplication
public class JhlogisticaApplication implements CommandLineRunner {

	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private TruckRepository truckRepository;
	
	@Autowired
	private FuelRepository fuelRepository;
	
	@Autowired
	private TransportRepository transportRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JhlogisticaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Driver driver = new Driver(null, "Josias Henrique");
		Truck truck = new Truck(null, "Iveco", "fbcin9c", driver);
		driver.getTrucks().add(truck);
		
		
		Fuel fuel = new Fuel(null, LocalDate.now(), 300.0,  new BigDecimal(1200.1), "Vargem Grande do Sul - SP", 4581245, truck);
		
		Transport transport = new Transport(null, "Transporte para empresa em Guarapuava - SP", LocalDate.now(), 12458, "Vargem Grande do Sul - SP", "Guarapuava - PR", new BigDecimal(15000.98), truck, Status.CONCLUDED);
		
		Transport transport1 = new Transport(null, "Transporte para empresa em Curitiba - PR", LocalDate.of(2022, 05, 21), 12458, "Vargem Grande do Sul - SP", "Curitiba - PR", new BigDecimal(32000.98), truck, Status.CONCLUDED);
		Transport transport2 = new Transport(null, "Transporte para empresa em Curitiba - SP", LocalDate.of(2022, 05, 15), 12458, "Itu - SP", "Curitiba - PR", new BigDecimal(25000.45), truck, Status.CONCLUDED);
		Transport transport3 = new Transport(null, "Transporte para empresa em Belo Horizonte - MG", LocalDate.of(2022, 03, 27), 12458, "São Paulo - SP", "Belo Horizonte - MG", new BigDecimal(13000.58), truck, Status.CONCLUDED);
		Transport transport4 = new Transport(null, "Transporte para empresa em Vargem Grande do Sul - SP", LocalDate.of(2022, 04, 8), 12458, "Guarapuava - PR", "Vargem Grande do Sul - SP", new BigDecimal(32300.08), truck, Status.CONCLUDED);
		Transport transport5 = new Transport(null, "Transporte para empresa em Curitiba - PR", LocalDate.of(2022, 03, 17), 12458, "Itu - SP", "Curitiba - PR", new BigDecimal(21000.31), truck, Status.CONCLUDED);
		Transport transport6 = new Transport(null, "Transporte para empresa em Ribeirão Preto - SP", LocalDate.of(2019, 05, 18), 12458, "Vargem Grande do Sul - SP", "Ribeirão Preto - SP", new BigDecimal(32500.09), truck, Status.CONCLUDED);
		
		driverRepository.saveAll(Arrays.asList(driver));
		truckRepository.saveAll(Arrays.asList(truck));
		fuelRepository.saveAll(Arrays.asList(fuel));
		transportRepository.saveAll(Arrays.asList(transport, transport1, transport2, transport3, transport4, transport5, transport6));
		
	}

}
