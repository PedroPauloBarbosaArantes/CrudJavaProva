package com.example.demo.controller;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDTO> listar() {
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public FuncionarioDTO salvar(@RequestBody FuncionarioDTO dto) {
        return funcionarioService.salvar(dto);
    }

    @PutMapping("/{id}")
    public FuncionarioDTO atualizar(@PathVariable Long id, @RequestBody FuncionarioDTO dto) {
        return funcionarioService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        funcionarioService.deletar(id);
    }
}
