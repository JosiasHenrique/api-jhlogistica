package com.api.jhlogistica.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_truck")
public class Truck implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String model;
	private String plate;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
	
	@JsonIgnore
	@OneToMany(mappedBy = "truck", cascade = CascadeType.ALL)
	private List<Fuel> fuels = new ArrayList<>();
	
	public Truck() {
		
	}
	
	public Truck(Integer id, String model, String plate, Driver driver) {
		this.id = id;
		this.model = model;
		this.plate = plate;
		this.driver = driver;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public List<Fuel> getFuels() {
		return fuels;
	}

}