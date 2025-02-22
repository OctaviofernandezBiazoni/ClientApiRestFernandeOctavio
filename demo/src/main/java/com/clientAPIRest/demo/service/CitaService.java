package com.clientAPIRest.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.clientAPIRest.demo.DTO.CitaResumenDTO;
import com.clientAPIRest.demo.DTO.DuenoFichaDTO;
import com.clientAPIRest.demo.modelo.Cita;
import com.clientAPIRest.demo.modelo.Dueno;
import com.clientAPIRest.demo.modelo.Peluquero;
import com.clientAPIRest.demo.repository.CitaRepository;
import com.clientAPIRest.demo.repository.DuenoRepository;

@Service
public class CitaService<CitaDTO> {

    private final CitaRepository citaRepository;
    private final DuenoRepository duenoRepository;

    public CitaService(CitaRepository citaRepository, DuenoRepository duenoRepository) {
        this.citaRepository = citaRepository;
        this.duenoRepository = duenoRepository;
    }

    // 📆 Listado de citas por peluquero en un día específico
    public List<CitaResumenDTO> getCitasPorDia(LocalDate fecha) {
        LocalDateTime inicio = fecha.atStartOfDay();
        LocalDateTime fin = fecha.plusDays(1).atStartOfDay();

        List<Cita> citas = citaRepository.findByFechaBetween(inicio, fin);

        // Agrupar por peluquero
        Map<Peluquero, List<Cita>> citasPorPeluquero = citas.stream()
                .collect(Collectors.groupingBy(Cita::getPeluquero));

        // Convertir en DTO
        return citasPorPeluquero.entrySet().stream()
                .map(entry -> new CitaResumenDTO(
                        entry.getKey().getNombre(),
                        entry.getValue().size(),
                        entry.getValue().stream().map(cita ->
                                new CitaResumenDTO.DetalleCita(
                                        cita.getMascota().getDueno().getNombre(),
                                        cita.getMascota().getNombre(),
                                        cita.getMascota().getDueno().getTelefono()
                                )
                        ).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    // 📝 Ficha del dueño con sus mascotas y la última fecha de baño
    public List<DuenoFichaDTO> getFichaDuenos() {
        List<Dueno> duenos = duenoRepository.findAll();
        return duenos.stream().map(dueno -> new DuenoFichaDTO(
                dueno.getNombre(),
                dueno.getApellido(),
                dueno.getTelefono(),
                dueno.getMascotas().stream().map(mascota -> {
                    Optional<Cita> ultimaCita = Optional.empty();
                    return new DuenoFichaDTO.DetalleMascota(
                            mascota.getNombre(),
                            ultimaCita.map(Cita::getFecha).orElse(null)
                    );
                }).collect(Collectors.toList())
        )).collect(Collectors.toList());
    }

    public List<CitaDTO> getAllCitas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCitas'");
    }

    public void deleteCita(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCita'");
    }

    public <CitaDTO> CitaDTO createCita(Long mascotaId, LocalDateTime fechaCita) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCita'");
    }
}

                                                    