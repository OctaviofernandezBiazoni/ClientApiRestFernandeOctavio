package com.clientAPIRest.demo.mapper;

import org.springframework.stereotype.Component;

import com.clientAPIRest.demo.DTO.DuenoDTO;
import com.clientAPIRest.demo.modelo.Dueno;

@Component
public class DuenoMapper {
    public DuenoDTO toDTO(Dueno dueno) {
        return new DuenoDTO(dueno.getId(), dueno.getNombre(), dueno.getApellido(), dueno.getTelefono());
    }

    public Dueno toEntity(DuenoDTO duenoDTO) {
        return new Dueno(duenoDTO.getNombre(), duenoDTO.getApellido(), duenoDTO.getTelefono());
    }
}
