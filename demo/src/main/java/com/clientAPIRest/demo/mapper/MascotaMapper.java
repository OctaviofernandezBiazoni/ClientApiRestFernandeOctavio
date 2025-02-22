package com.clientAPIRest.demo.mapper;

import org.springframework.stereotype.Component;

import com.clientAPIRest.demo.DTO.MascotaDTO;
import com.clientAPIRest.demo.modelo.Mascota;

@Component
public class MascotaMapper {
    public MascotaDTO toDTO(Mascota mascota) {
        return new MascotaDTO(mascota.getId(), mascota.getNombre(), mascota.getTipo().toString(), 
                              mascota.getRaza(), mascota.getDueno().getId(), 
                              mascota.getPeluquero() != null ? ((MascotaDTO) mascota.getPeluquero()).getId() : null);
    }

    public Mascota toEntity(MascotaDTO mascotaDTO) {
        return new Mascota(mascotaDTO.getNombre(), null, mascotaDTO.getRaza(), null);
    }
}
