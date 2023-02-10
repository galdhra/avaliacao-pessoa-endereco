package com.galdhra.Pessoa.DTO;

import com.galdhra.Pessoa.entities.*;

public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private Boolean principal;
    private String cidade;
    private UnidadeFederativa UF;


    public EnderecoDTO(Long id, String logradouro, String cep, Integer numero, Boolean principal, String cidade, UnidadeFederativa UF) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.principal = principal;
        this.cidade = cidade;
        this.UF = UF;
    }

    public EnderecoDTO(Endereco entity) {
        id = entity.getId();
        logradouro = entity.getLogradouro();
        cep = entity.getCep();
        numero = entity.getNumero();
        principal = entity.getPrincipal();
        cidade = entity.getCidade();
        UF = entity.getUF();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederativa getUF() {
        return UF;
    }

    public void setUF(UnidadeFederativa UF) {
        this.UF = UF;
    }
}
