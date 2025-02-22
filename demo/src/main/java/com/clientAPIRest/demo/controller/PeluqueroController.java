package com.clientAPIRest.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientAPIRest.demo.DTO.PeluqueroDTO;
import com.clientAPIRest.demo.mapper.PeluqueroMapper;
import com.clientAPIRest.demo.modelo.Peluquero;
import com.clientAPIRest.demo.repository.PeluqueroRepository;

@RestController
@RequestMapping("/peluqueros")
public class PeluqueroController {

    private final PeluqueroRepository peluqueroRepository;
    private final PeluqueroMapper peluqueroMapper;

    public PeluqueroController(PeluqueroRepository peluqueroRepository, PeluqueroMapper peluqueroMapper) {
        this.peluqueroRepository = peluqueroRepository;
        this.peluqueroMapper = peluqueroMapper;
    }

    @GetMapping
    public List<PeluqueroDTO> getAll() {
        return peluqueroRepository.findAll().stream()
                .map(peluqueroMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PeluqueroDTO> create(@RequestBody PeluqueroDTO peluqueroDTO) {
        Peluquero peluquero = peluqueroMapper.toEntity(peluqueroDTO);
        Peluquero savedPeluquero = peluqueroRepository.save(peluquero);
        return ResponseEntity.ok(peluqueroMapper.toDTO(savedPeluquero));
    }
}
