package com.clientAPIRest.demo.repository;

import com.clientAPIRest.demo.modelo.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenoRepository extends JpaRepository<Dueno, Long> {
}
