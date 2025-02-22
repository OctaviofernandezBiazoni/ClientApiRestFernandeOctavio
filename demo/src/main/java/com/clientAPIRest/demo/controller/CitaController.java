package com.clientAPIRest.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientAPIRest.demo.DTO.CitaResumenDTO;
import com.clientAPIRest.demo.DTO.DuenoFichaDTO;
import com.clientAPIRest.demo.service.CitaService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    // 📌 1. Obtener citas por fecha en formato JSON
    @GetMapping("/fecha/{fecha}")
    public List<CitaResumenDTO> getCitasPorFecha(@PathVariable String fecha) {
        return citaService.getCitasPorDia(LocalDate.parse(fecha));
    }

    // 📌 2. Obtener ficha de dueños con mascotas y última cita de baño
    @GetMapping("/duenos")
    public List<DuenoFichaDTO> getFichaDuenos() {
        return citaService.getFichaDuenos();
    }
}
