package com.clientAPIRest.demo.repository;

import com.clientAPIRest.demo.modelo.Cita;
import com.clientAPIRest.demo.modelo.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByMascotaOrderByFechaDesc(Mascota mascota);

    List<Cita> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
}
