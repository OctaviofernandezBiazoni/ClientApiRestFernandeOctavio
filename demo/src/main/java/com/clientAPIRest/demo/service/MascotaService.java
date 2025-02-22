package com.clientAPIRest.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.clientAPIRest.demo.DTO.MascotaDTO;
import com.clientAPIRest.demo.mapper.MascotaMapper;
import com.clientAPIRest.demo.modelo.Dueno;
import com.clientAPIRest.demo.modelo.Mascota;
import com.clientAPIRest.demo.repository.DuenoRepository;
import com.clientAPIRest.demo.repository.MascotaRepository;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final DuenoRepository duenoRepository;
    private final MascotaMapper mascotaMapper;

    public MascotaService(MascotaRepository mascotaRepository, DuenoRepository duenoRepository, MascotaMapper mascotaMapper) {
        this.mascotaRepository = mascotaRepository;
        this.duenoRepository = duenoRepository;
        this.mascotaMapper = mascotaMapper;
    }

    public List<MascotaDTO> getAllMascotas() {
        return mascotaRepository.findAll().stream()
                .map(mascotaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MascotaDTO getMascotaById(Long id) {
        Optional<Mascota> mascota = mascotaRepository.findById(id);
        return mascota.map(mascotaMapper::toDTO).orElse(null);
    }

    public MascotaDTO createMascota(MascotaDTO mascotaDTO) {
        Mascota mascota = mascotaMapper.toEntity(mascotaDTO);
        Optional<Dueno> dueno = duenoRepository.findById(mascotaDTO.getDuenoId());

        dueno.ifPresent(mascota::setDueno);
        Mascota savedMascota = mascotaRepository.save(mascota);
        return mascotaMapper.toDTO(savedMascota);
    }

    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}
