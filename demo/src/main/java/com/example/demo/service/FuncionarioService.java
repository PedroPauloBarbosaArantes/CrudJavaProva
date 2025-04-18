package com.example.demo.service;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> listarTodos() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(f -> {
            FuncionarioDTO dto = new FuncionarioDTO();
            dto.setId(f.getId());
            dto.setNome(f.getNome());
            dto.setCpf(f.getCpf());  // Mapeando CPF
            return dto;
        }).collect(Collectors.toList());
    }

    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());  // Salvando CPF
        funcionario = funcionarioRepository.save(funcionario);
        dto.setId(funcionario.getId());
        return dto;
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioDTO atualizar(Long id, FuncionarioDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());  // Atualizando CPF
        funcionario = funcionarioRepository.save(funcionario);
        dto.setId(funcionario.getId());
        return dto;
    }
}
