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

import com.api.jhlogistica.domain.enums.Status;


@Entity
@Table(name = "tb_transport")
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private LocalDate date;
	private Integer cte;
	private String start;
	private String destination;
	private BigDecimal amount;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name="truck_id")
	private Truck truck; 
	
	public Transport() {
		
	}

	public Transport(Long id, String title, LocalDate date, Integer cte, String start, String destination, BigDecimal amount,
			Truck truck, Status status) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.cte = cte;
		this.start = start;
		this.destination = destination;
		this.amount = amount;
		this.truck = truck;
		this.status = status.getCod();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getCte() {
		return cte;
	}

	public void setCte(Integer cte) {
		this.cte = cte;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	
	public Status getStatus() {
		return Status.toEnum(status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}
	
}