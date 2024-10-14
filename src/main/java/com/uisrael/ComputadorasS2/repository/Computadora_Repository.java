package com.uisrael.ComputadorasS2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uisrael.ComputadorasS2.modelo.Computadoras;

@Repository
public interface Computadora_Repository extends JpaRepository<Computadoras, Integer>{
	
}
