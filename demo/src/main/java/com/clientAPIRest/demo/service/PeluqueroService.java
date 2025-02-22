package com.clientAPIRest.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.clientAPIRest.demo.DTO.PeluqueroDTO;
import com.clientAPIRest.demo.mapper.PeluqueroMapper;
import com.clientAPIRest.demo.modelo.Peluquero;
import com.clientAPIRest.demo.repository.PeluqueroRepository;

@Service
public class PeluqueroService {

    private final PeluqueroRepository peluqueroRepository;
    private final PeluqueroMapper peluqueroMapper;

    public PeluqueroService(PeluqueroRepository peluqueroRepository, PeluqueroMapper peluqueroMapper) {
        this.peluqueroRepository = peluqueroRepository;
        this.peluqueroMapper = peluqueroMapper;
    }

    public List<PeluqueroDTO> getAllPeluqueros() {
        return peluqueroRepository.findAll().stream()
                .map(peluqueroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PeluqueroDTO getPeluqueroById(Long id) {
        Optional<Peluquero> peluquero = peluqueroRepository.findById(id);
        return peluquero.map(peluqueroMapper::toDTO).orElse(null);
    }

    public PeluqueroDTO createPeluquero(PeluqueroDTO peluqueroDTO) {
        Peluquero peluquero = peluqueroMapper.toEntity(peluqueroDTO);
        return peluqueroMapper.toDTO(peluqueroRepository.save(peluquero));
    }

    public void deletePeluquero(Long id) {
        peluqueroRepository.deleteById(id);
    }
}
