package com.api.jhlogistica.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_fuel")
public class Fuel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private Double liter;
	private BigDecimal price;
	private String local;
	private Integer odometer;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="truck_id")
	private Truck truck;
	
	public Fuel() {
		
	}

	public Fuel(Long id, LocalDate date, Double liter, BigDecimal price,
			String local, Integer odometer, Truck truck) {
		this.id = id;
		this.date = date;
		this.liter = liter;
		this.price = price;
		this.local = local;
		this.odometer = odometer;
		this.truck = truck;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getLiter() {
		return liter;
	}

	public void setLiter(Double liter) {
		this.liter = liter;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getOdometer() {
		return odometer;
	}

	public void setOdometer(Integer odometer) {
		this.odometer = odometer;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

}