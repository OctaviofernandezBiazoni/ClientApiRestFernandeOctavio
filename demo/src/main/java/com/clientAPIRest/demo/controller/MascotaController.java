package com.clientAPIRest.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientAPIRest.demo.DTO.MascotaDTO;
import com.clientAPIRest.demo.mapper.MascotaMapper;
import com.clientAPIRest.demo.modelo.Mascota;
import com.clientAPIRest.demo.repository.MascotaRepository;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaRepository mascotaRepository;
    private final MascotaMapper mascotaMapper;

    public MascotaController(MascotaRepository mascotaRepository, MascotaMapper mascotaMapper) {
        this.mascotaRepository = mascotaRepository;
        this.mascotaMapper = mascotaMapper;
    }

    @GetMapping
    public List<MascotaDTO> getAll() {
        return mascotaRepository.findAll().stream()
                .map(mascotaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<MascotaDTO> create(@RequestBody MascotaDTO mascotaDTO) {
        Mascota mascota = mascotaMapper.toEntity(mascotaDTO);
        Mascota savedMascota = mascotaRepository.save(mascota);
        return ResponseEntity.ok(mascotaMapper.toDTO(savedMascota));
    }
}
