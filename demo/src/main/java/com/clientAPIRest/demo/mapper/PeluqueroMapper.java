package com.clientAPIRest.demo.mapper;

import org.springframework.stereotype.Component;

import com.clientAPIRest.demo.DTO.PeluqueroDTO;
import com.clientAPIRest.demo.modelo.Peluquero;

@Component
public class PeluqueroMapper {
    public PeluqueroDTO toDTO(Peluquero peluquero) {
        return new PeluqueroDTO(peluquero.getId(), peluquero.getNombre());
    }

    public Peluquero toEntity(PeluqueroDTO peluqueroDTO) {
        return new Peluquero(peluqueroDTO.getNombre());
    }
}
