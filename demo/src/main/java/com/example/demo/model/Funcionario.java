package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @OneToMany(mappedBy = "funcionario")
    private Set<Trabalho> trabalhos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(Set<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }
}
