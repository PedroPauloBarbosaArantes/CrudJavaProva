package com.example.demo.controller;

import com.example.demo.dto.TrabalhoDTO;
import com.example.demo.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping
    public TrabalhoDTO salvar(@RequestBody TrabalhoDTO dto) {
        return trabalhoService.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        trabalhoService.deletar(id);
    }
}

