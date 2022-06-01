package com.api.jhlogistica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.jhlogistica.domain.Truck;


public interface TruckRepository extends JpaRepository<Truck, Integer> {

}