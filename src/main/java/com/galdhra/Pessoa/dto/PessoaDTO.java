package com.galdhra.Pessoa.dto;

import com.galdhra.Pessoa.entities.*;
import jakarta.validation.constraints.*;

import java.time.*;
import java.util.*;

public class PessoaDTO {
    private Long id;
    @Size(min = 3, max = 80, message="Nome deve conter entre 3 e 80 caracteres")
    @NotBlank(message="Campo requerido")
    private String nome;
    @Past
    private LocalDate dataDeNascimento;

    private List<EnderecoDTO> enderecos = new ArrayList<>();

    public PessoaDTO(){

    }

    public PessoaDTO(Long id, String nome, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public PessoaDTO(Pessoa entity) {
        id = entity.getId();
        nome = entity.getNome();
        dataDeNascimento = entity.getDataDeNascimento();
        for(Endereco end: entity.getEnderecos()){
            enderecos.add(new EnderecoDTO(end));}
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

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }
}
