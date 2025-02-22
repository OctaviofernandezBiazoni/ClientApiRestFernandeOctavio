package com.clientAPIRest.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientAPIRest.demo.DTO.DuenoDTO;
import com.clientAPIRest.demo.mapper.DuenoMapper;
import com.clientAPIRest.demo.modelo.Dueno;
import com.clientAPIRest.demo.repository.DuenoRepository;

@RestController
@RequestMapping("/duenos")
public class DuenoController {

    private final DuenoRepository duenoRepository;
    private final DuenoMapper duenoMapper;

    public DuenoController(DuenoRepository duenoRepository, DuenoMapper duenoMapper) {
        this.duenoRepository = duenoRepository;
        this.duenoMapper = duenoMapper;
    }

    @GetMapping
    public List<DuenoDTO> getAll() {
        return duenoRepository.findAll().stream()
                .map(duenoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<DuenoDTO> create(@RequestBody DuenoDTO duenoDTO) {
        Dueno dueno = duenoMapper.toEntity(duenoDTO);
        Dueno savedDueno = duenoRepository.save(dueno);
        return ResponseEntity.ok(duenoMapper.toDTO(savedDueno));
    }
}
