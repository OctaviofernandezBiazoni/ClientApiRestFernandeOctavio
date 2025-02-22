package com.clientAPIRest.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.clientAPIRest.demo.DTO.DuenoDTO;
import com.clientAPIRest.demo.mapper.DuenoMapper;
import com.clientAPIRest.demo.modelo.Dueno;
import com.clientAPIRest.demo.repository.DuenoRepository;

@Service
public class DuenoService {

    private final DuenoRepository duenoRepository;
    private final DuenoMapper duenoMapper;

    public DuenoService(DuenoRepository duenoRepository, DuenoMapper duenoMapper) {
        this.duenoRepository = duenoRepository;
        this.duenoMapper = duenoMapper;
    }

    public List<DuenoDTO> getAllDuenos() {
        return duenoRepository.findAll().stream()
                .map(duenoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DuenoDTO getDuenoById(Long id) {
        Optional<Dueno> dueno = duenoRepository.findById(id);
        return dueno.map(duenoMapper::toDTO).orElse(null);
    }

    public DuenoDTO createDueno(DuenoDTO duenoDTO) {
        Dueno dueno = duenoMapper.toEntity(duenoDTO);
        return duenoMapper.toDTO(duenoRepository.save(dueno));
    }

    public void deleteDueno(Long id) {
        duenoRepository.deleteById(id);
    }
}
