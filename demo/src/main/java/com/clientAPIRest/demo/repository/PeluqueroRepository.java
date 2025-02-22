package com.clientAPIRest.demo.repository;

import com.clientAPIRest.demo.modelo.Peluquero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeluqueroRepository extends JpaRepository<Peluquero, Long> {
}
