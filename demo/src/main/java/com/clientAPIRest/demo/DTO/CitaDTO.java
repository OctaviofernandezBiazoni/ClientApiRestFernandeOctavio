package com.clientAPIRest.demo.DTO;

import java.time.LocalDateTime;

public class CitaDTO {

    private Long id;
    private Long mascotaId;
    private Long peluqueroId;
    private LocalDateTime fecha;

    public CitaDTO(Long id, Long mascotaId, Long peluqueroId, LocalDateTime fecha) {
        this.id = id;
        this.mascotaId = mascotaId;
        this.peluqueroId = peluqueroId;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public Long getMascotaId() {
        return mascotaId;
    }

    public Long getPeluqueroId() {
        return peluqueroId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
