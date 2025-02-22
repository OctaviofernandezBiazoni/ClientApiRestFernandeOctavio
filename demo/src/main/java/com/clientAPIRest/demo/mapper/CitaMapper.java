package com.clientAPIRest.demo.mapper;

import org.springframework.stereotype.Component;

import com.clientAPIRest.demo.DTO.CitaDTO;
import com.clientAPIRest.demo.modelo.Cita;

@Component
public class CitaMapper {

    public CitaDTO toDTO(Cita cita) {
        return new CitaDTO(
                cita.getId(),
                cita.getMascota().getId(),
                cita.getPeluquero().getId(),
                cita.getFecha()
        );
    }
}
