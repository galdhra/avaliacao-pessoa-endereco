package com.galdhra.Pessoa.entities;

import jakarta.persistence.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeNascimento;


    @OneToMany(mappedBy = "morador",cascade=CascadeType.PERSIST)
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(){

    }

    public Pessoa(Long id, String nome, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }
}
