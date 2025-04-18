package com.example.demo.service;

import com.example.demo.dto.TrabalhoDTO;
import com.example.demo.model.Funcionario;
import com.example.demo.model.Trabalho;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public TrabalhoDTO salvar(TrabalhoDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(dto.getFuncionarioId()).orElseThrow();

        Trabalho trabalho = new Trabalho();
        trabalho.setEndereco(dto.getEndereco());
        trabalho.setFuncionario(funcionario);

        trabalho = trabalhoRepository.save(trabalho);
        dto.setId(trabalho.getId());
        return dto;
    }

    public void deletar(Long id) {
        trabalhoRepository.deleteById(id);
    }
}

